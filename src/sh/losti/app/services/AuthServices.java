package sh.losti.app.services;

import org.mindrot.jbcrypt.BCrypt;

import sh.losti.app.db.Client;
import sh.losti.app.interfaces.services.IAuthServices;
import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class AuthServices implements IAuthServices {
    private static final Logger logger = Logger.getLogger(AuthServices.class.getName());
    private static AuthServices instance;
    private static final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
    private static final Pattern PASSWORD_REGEX = Pattern.compile("\"\\\\A(?=\\\\S*?[0-9])(?=\\\\S*?[a-z])(?=\\\\S*?[A-Z])(?=\\\\S*?[@#$%^&+=])\\\\S{8,}\\\\z\"");

    private static final String VERIFY_SESSION = """
                SELECT s.session_id, s.user_id, s.session_key, s.expires_at,
                           u.name, u.nameId, u.email
                    FROM sessions s
                    JOIN users u ON s.user_id = u.id
                    WHERE s.session_key = ?
                    LIMIT 1
            """;
    private static final String DELETE_SESSION = "DELETE FROM sessions WHERE session_key=?";
    private static final String CREATE_SESSION = "INSERT INTO sessions (user_id, session_key, expires_at) VALUES (?, ?, ?)";
    private static final String GET_CURRENT_SESSION = "SELECT session_id, user_id, session_key, expires_at FROM sessions WHERE session_key=? LIMIT 1";
    private static final String LOGIN_GET_DATA = "SELECT id, name, nameId, email FROM users WHERE email = ? LIMIT 1";
    private static final String LOGIN_GET_HASHED_PWD = "SELECT password FROM users WHERE email = ? LIMIT 1";
    private static final String SIGN_UP_QUERY = "INSERT INTO users (name, nameId, email, password) VALUES (?, ?, ?, ?)";

    private Session session = null;
    private SessionData session_data = null;

    private AuthServices() {}

    public static synchronized AuthServices getInstance() {
        if (instance == null) {
            instance = new AuthServices();
        }
        return instance;
    }

    private String generateNameId(String name) {
        return name
                .toLowerCase() // convertir a minúsculas
                .trim() // eliminar espacios al inicio y al final
                .replaceAll("[^a-z0-9\\s]", "") // eliminar todo lo que no sea letra, número o espacio
                .replaceAll("\\s+", "-"); // reemplazar espacios (uno o más) por guiones
    }

    @Override
    public boolean isValidSession(Session session) {
        try (PreparedStatement ps = Client.getPreparedStatement(VERIFY_SESSION)) {
            ps.setString(1, session.getSession_key());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) return false;

            Timestamp expires_at = rs.getTimestamp("expires_at");
            Date now = new Date();

            if (expires_at.before(now)) {
                try (PreparedStatement delete = Client.getPreparedStatement(DELETE_SESSION)) {
                    delete.setString(1, session.getSession_key());
                    delete.executeUpdate();
                }
                return false;
            }

            this.session = new Session(
                    rs.getInt("session_id"),
                    rs.getInt("user_id"),
                    rs.getString("session_key"),
                    new Date(expires_at.getTime())
            );

            this.session_data = new SessionData(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("nameId"),
                    rs.getString("email")
            );

            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% Error checking session", e);
            return false;
        }
    }

    @Override
    public boolean isValidEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    @Override
    public boolean isValidPassword(String password) {
        return PASSWORD_REGEX.matcher(password).matches();
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public boolean setSession(Session session) {
        return false;
    }

    @Override
    public SessionData getSessionData() {
        return session_data;
    }

    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    @Override
    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    @Override
    public boolean login(String email, String password) {
        String savedHashedPassword = null;

        try (PreparedStatement ps = Client.getPreparedStatement(LOGIN_GET_HASHED_PWD)) {
            ps.setString(1, email);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            if (!rs.next()) {
                return false;
            }

            savedHashedPassword = rs.getString(1);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        }

        if (!checkPassword(password, savedHashedPassword)) {
            return false;
        }

        try (PreparedStatement ps = Client.getPreparedStatement(LOGIN_GET_DATA)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return false;
            }

            session_data = new SessionData(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                    );
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        }

        long now = System.currentTimeMillis();
        long threeDaysMillis = 3L * 24 * 60 * 60 * 1000;
        long expiryMillis = now + threeDaysMillis;

        Timestamp expiresAt = new Timestamp(expiryMillis);

        try (PreparedStatement ps = Client.getPreparedStatement(CREATE_SESSION)) {
            ps.setInt(1, session_data.getId());
            ps.setString(2, session_data.getEmail());
            ps.setTimestamp(3, expiresAt);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        }

        try (PreparedStatement ps = Client.getPreparedStatement(GET_CURRENT_SESSION)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return false;
            }

            session = new Session(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getTimestamp(4)
                );
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        }

        return true;
    }

    @Override
    public boolean signUp(String name, String email, String password) {
        String nameId = generateNameId(name);
        String hashedPassword = hashPassword(password);
        boolean result = checkPassword(password, hashedPassword);

        if (!result) {
            return false;
        }

        try (PreparedStatement ps = Client.getPreparedStatement(SIGN_UP_QUERY)) {
            ps.setString(1, name);
            ps.setString(2, nameId);
            ps.setString(3, email);
            ps.setString(4, hashedPassword);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        };

        return true;
    }

    @Override
    public void logout() {

    }
}
