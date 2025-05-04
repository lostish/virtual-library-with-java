package sh.losti.app.services;

import org.mindrot.jbcrypt.BCrypt;

import sh.losti.app.builders.LogBuilder;
import sh.losti.app.constants.AuthConstants;
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
    }

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

            return true;
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
    public boolean isValidEmail(String email) {
        return AuthConstants.getEmailRegex().matcher(email).matches();
    }

    @Override
    public boolean isValidPassword(String password) { return AuthConstants.getPasswordRegex().matcher(password).matches(); }

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
    public String getHashedPassword(String email) { return dao.getHashedPassword(email); }

    @Override
    public boolean checkPassword(String password, String hashedPassword) { return BCrypt.checkpw(password, hashedPassword); }

    @Override
    public boolean login(String email, String password) {
        String savedHashedPassword = dao.getHashedPassword(email);

        if (savedHashedPassword == null || !checkPassword(password, savedHashedPassword)) {
            return false;
        }

        session_data = dao.getSessionData(email);

        dao.createSession(session_data.getId(), session_data.getEmail());

        session = dao.getSession(session_data.getEmail());

        return session != null;
    }

    @Override
    public boolean signUp(String name, String email, String password) {
        String nameId = generateNameId(name);
        String hashedPassword = hashPassword(password);
        boolean result = checkPassword(password, hashedPassword);

        if (!result) {
            return false;
        }

        return dao.createUser(name, nameId, email, hashedPassword);
    }

    @Override
    public void changePassword(String email, String password) {
        dao.updateHashedPassword(email, password);
    };

    @Override
    public void logout() {
        dao.deleteSession(session.getSessionKey());
    }
}
