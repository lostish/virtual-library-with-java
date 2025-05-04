package sh.losti.app.dao;

import sh.losti.app.db.Client;
import sh.losti.app.enums.EVerifySessionData;
import sh.losti.app.interfaces.dao.IDaoAuth;
import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;
import sh.losti.app.utils.VerifySessionResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthDaoImpl implements IDaoAuth {
    private static final Logger logger = Logger.getLogger(AuthDaoImpl.class.getName());
    private static AuthDaoImpl instance;

    private static final String VERIFY_SESSION = """
                SELECT s.session_id, s.user_id, s.session_key, s.expires_at,
                           u.name, u.nameId, u.email
                    FROM sessions s
                    JOIN users u ON s.user_id = u.id
                    WHERE s.session_key = ?
                    LIMIT 1
            """;
    private static final String CREATE_SESSION = "INSERT INTO sessions (user_id, session_key, expires_at) VALUES (?, ?, ?)";
    private static final String GET_CURRENT_SESSION = "SELECT session_id, user_id, session_key, created_at, expires_at FROM sessions WHERE session_key=? LIMIT 1";
    private static final String DELETE_SESSION = "DELETE FROM sessions WHERE session_key=?";
    private static final String LOGIN_GET_DATA = "SELECT id, name, nameId, email FROM users WHERE email = ? LIMIT 1";
    private static final String LOGIN_GET_HASHED_PWD = "SELECT password FROM users WHERE email = ? LIMIT 1";
    private static final String CREATE_USER = "INSERT INTO users (name, nameId, email, password) VALUES (?, ?, ?, ?)";
    private static final String GET_SESSION_DATA = "SELECT id, name, nameId, email FROM users WHERE id = ? AND email = ? LIMIT 1";
    private static final String UPADTE_USER_PWD = "UPDATE users SET password = ? WHERE email = ?";

    private AuthDaoImpl() {}

    public static synchronized AuthDaoImpl getInstance() {
        if (instance == null) {
            instance = new AuthDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean createUser(String name, String nameId, String email, String password) {
        try (PreparedStatement ps = Client.getPreparedStatement(CREATE_USER)) {
            ps.setString(1, name);
            ps.setString(2, nameId);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return false;
        }
    }

    @Override
    public ResultSet verifySession(Session session) {
        try (PreparedStatement ps = Client.getPreparedStatement(VERIFY_SESSION)) {
            ps.setString(1, session.getSessionKey());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) throw new SQLException();

            Timestamp expires_at = rs.getTimestamp("expires_at");
            Date now = new Date();

            if (expires_at.before(now)) {
                try (PreparedStatement delete = Client.getPreparedStatement(DELETE_SESSION)) {
                    delete.setString(1, session.getSessionKey());
                    delete.executeUpdate();
                }
                return null;
            }

            return rs;
        } catch (SQLException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    @Override
    public VerifySessionResult verifySessionData(SessionData currentSessionData) {
        try (PreparedStatement ps = Client.getPreparedStatement(GET_SESSION_DATA)) {
            ps.setInt(1, currentSessionData.getId());
            ps.setString(2, currentSessionData.getEmail());
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                return new VerifySessionResult(EVerifySessionData.NOT_VERIFIED, null);

            SessionData fresh = new SessionData(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("nameId"),
                    rs.getString("email"));

            boolean changed = !currentSessionData.getName().equals(fresh.getName())
                    || !currentSessionData.getNameId().equals(fresh.getNameId())
                    || !currentSessionData.getEmail().equals(fresh.getEmail());

            EVerifySessionData status = changed
                    ? EVerifySessionData.UPDATED
                    : EVerifySessionData.VERIFIED;

            return new VerifySessionResult(status, fresh);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES - VerifySessionData error:", e);
            return new VerifySessionResult(EVerifySessionData.ERROR, null);
        }
    }

    @Override
    public String getHashedPassword(String email) {
        try (PreparedStatement ps = Client.getPreparedStatement(LOGIN_GET_HASHED_PWD)) {
            ps.setString(1, email);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            if (!rs.next()) throw new SQLException();

            return rs.getString(1);
        } catch (SQLException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    @Override
    public void updateHashedPassword(String email, String newPwd) {
        try (PreparedStatement ps = Client.getPreparedStatement(UPADTE_USER_PWD)) {
            ps.setString(1, newPwd);
            ps.setString(2, email);
            int rs =  ps.executeUpdate();

            if (rs > 0) {
                logger.log(Level.INFO, "% AUTH DAO IMPL - Update password");
                return;
            }
            logger.log(Level.SEVERE, "% AUTH DAO IMPL - Password has been not update");
        }
        catch (SQLException e) {
            e.fillInStackTrace();
        }
      };

    @Override
    public SessionData getSessionData(String email) {
        try (PreparedStatement ps = Client.getPreparedStatement(LOGIN_GET_DATA)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) throw new SQLException();

            return new SessionData(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        } catch (SQLException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    @Override
    public void createSession(int id, String email) {
        long now = System.currentTimeMillis();
        long threeDaysMillis = 3L * 24 * 60 * 60 * 1000;
        long expiryMillis = now + threeDaysMillis;

        Timestamp expiresAt = new Timestamp(expiryMillis);

        try (PreparedStatement ps = Client.getPreparedStatement(CREATE_SESSION)) {
            ps.setInt(1, id);
            ps.setString(2, email);
            ps.setTimestamp(3, expiresAt);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
        }
    }

    @Override
    public Session getSession(String email) {
        try (PreparedStatement ps = Client.getPreparedStatement(GET_CURRENT_SESSION)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) throw new SQLException();

            return new Session(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getTimestamp(4),
                    rs.getTimestamp(5)
            );
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
            return null;
        }
    }

    @Override
    public void deleteSession(String key) {
        try (PreparedStatement ps = Client.getPreparedStatement(DELETE_SESSION)) {
            ps.setString(1, key);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
        }
    }
}
