package sh.losti.app.services;

import org.mindrot.jbcrypt.BCrypt;

import sh.losti.app.builders.LogBuilder;
import sh.losti.app.constants.AuthConstants;
import sh.losti.app.context.AuthContext;
import sh.losti.app.dao.AuthDaoImpl;
import sh.losti.app.enums.ELogLevel;
import sh.losti.app.enums.EVerifySessionData;
import sh.losti.app.interfaces.services.IAuthServices;
import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;
import sh.losti.app.utils.LogTimer;
import sh.losti.app.utils.VerifySessionResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthServices implements IAuthServices {
    private static final Logger logger = Logger.getLogger(AuthServices.class.getName());
    private static final AuthDaoImpl dao = AuthDaoImpl.getInstance();
    private static AuthServices instance;

    private Session session = null;
    private SessionData session_data = null;

    private AuthServices() {
    }

    public static synchronized AuthServices getInstance() {
        if (instance == null) {
            try {
                instance = new AuthServices();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error al crear AuthServices", e);
                throw new RuntimeException("No se pudo inicializar AuthServices", e);
            }
        }
        return instance;
    }

    private String generateNameId(String name) {
        return name
                .toLowerCase() // convertir a minúsculas
                .trim() // eliminar espacios al inicio y al final
                .replaceAll("[^a-z0-9\\s]", "") // eliminar todo lo que no sea letra, número o espacio
                .replaceAll("\\s+", "-"); // reemplazar espacios (uno o más) por guiones
                //+ "-" + UUID.randomUUID().toString().substring(0, 6);
    }

    /*
    public AuthContext getAuthContext(Session session) {
        try (ResultSet rs = dao.verifySession(session)) {
            if (rs == null) return null;

            Session validSession = new Session(
                    rs.getInt("session_id"),
                    rs.getInt("user_id"),
                    rs.getString("session_key"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("expires_at")
            );

            SessionData sessionData = new SessionData(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("nameId"),
                    rs.getString("email")
            );

            return new AuthContext(validSession, sessionData);
        } catch (Exception e) {
            return null;
        }
    }
    */

    @Override
    public boolean isValidSession(Session session) {
        LogTimer timer = LogTimer.start();
        try (ResultSet rs = dao.verifySession(session)) {
            if (rs == null) {
                return false;
            }
            Timestamp created_at = rs.getTimestamp("created_at");
            Timestamp expires_at = rs.getTimestamp("expires_at");

            this.session = new Session(
                    rs.getInt("session_id"),
                    rs.getInt("user_id"),
                    rs.getString("session_key"),
                    new Date(created_at.getTime()),
                    new Date(expires_at.getTime())
            );
            this.session_data = new SessionData(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("nameId"),
                    rs.getString("email"));

            return expires_at.after(new Date());
        } catch (SQLException e) {
            long duration = timer.millis();
            String logFormat = new LogBuilder()
                    .setLevel(ELogLevel.DATABASE)
                    .setCreateBy(getClass().getName())
                    .setAction("AuthServices.isValidSession")
                    .setMessage("Verify session expired or invalid data")
                    .setData(session.toString())
                    .setErrors(null)
                    .setLocation(e)
                    .setLocalTimestamp(System.currentTimeMillis())
                    .setDuration(duration)
                    .formatLog();
            logger.config(logFormat);
            return false;
        }
    }

    @Override
    public VerifySessionResult verifySessionData(SessionData currentSessionData) {
        if (currentSessionData == null || currentSessionData.getEmail() == null) {
            return new VerifySessionResult(EVerifySessionData.NOT_VERIFIED, null);
        }

        return dao.verifySessionData(currentSessionData);
    };

    @Override
    public boolean isValidEmail(String email) { return email != null && AuthConstants.getEmailRegex().matcher(email).matches(); }

    @Override
    public boolean isValidPassword(String password) { return password != null && AuthConstants.getPasswordRegex().matcher(password).matches(); }

    @Override
    public Session getSession() {
        return this.session;
    }

    @Override
    public boolean setSession(Session session) {
        return false;
    }

    @Override
    public SessionData getSessionData() {
        return this.session_data;
    }

    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    @Override
    public String getHashedPassword(String email) { return dao.getHashedPassword(email); }

    @Override
    public boolean checkPassword(String password, String hashedPassword) { return BCrypt.checkpw(password, hashedPassword); }

    @Override
    public boolean login(String email, String password) {
        if (email == null || password == null) {
            logger.warning("AUTH SERVICES login(): email or password is null");
            return false;
        }
        if (!isValidEmail(email) || !isValidPassword(password)) {
            logger.warning("AUTH SERVICES login(): invalid email or password format");
            return false;
        }

        String savedHashedPassword = dao.getHashedPassword(email);
        System.out.println("[DEBUG] AUTH SERVICES [POST] - LOGIN PROCESS");
        if (savedHashedPassword == null || !checkPassword(password, savedHashedPassword)) {
            logger.info("AUTH SERVICES login(): no user found for email=" + email);
            return false;
        }
        System.out.println("[DEBUG] AUTH SERVICES [POST] - VALID PWD");

        this.session_data = dao.getSessionData(email);

        System.out.println("[DEBUG] AUTH SERVICES [POST] - GET SESSION DATA");
        System.out.println("[DEBUG] AUTH SERVICES [POST] - SD: " + session_data.toString());

        dao.createSession(this.session_data.getId(), this.session_data.getEmail());

        System.out.println("[DEBUG] AUTH SERVICES [POST] - Creating a session");

        this.session = dao.getSession(this.session_data.getEmail());

        System.out.println("[DEBUG] AUTH SERVICES [POST] - Session exists?: " + session.toString());

        return this.session != null;
    }

    @Override
    public boolean signUp(String name, String email, String password) {
        if (name == null || name.isBlank() || !isValidEmail(email) || !isValidPassword(password)) {
            return false;
        }

        if (dao.userExists(email)) return false;

        String nameId = generateNameId(name);
        String hashedPassword = hashPassword(password);
        return dao.createUser(name, nameId, email, hashedPassword);
    }

    @Override
    public void changePassword(String email, String password) {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("La nueva contraseña no cumple la política");
        }
        String hashed = hashPassword(password);
        dao.updateHashedPassword(email, hashed);
    };

    @Override
    public void logout(String sessionKey) {
        dao.deleteSession(sessionKey);
    }
}
