package sh.losti.app.services;

import org.mindrot.jbcrypt.BCrypt;

import sh.losti.app.db.Client;
import sh.losti.app.interfaces.services.IAuthServices;
import sh.losti.app.models.Session;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class AuthServices implements IAuthServices {
    private static final Logger logger = Logger.getLogger(AuthServices.class.getName());
    private static AuthServices instance;
    private static final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
    private static final Pattern PASSWORD_REGEX = Pattern.compile("\"\\\\A(?=\\\\S*?[0-9])(?=\\\\S*?[a-z])(?=\\\\S*?[A-Z])(?=\\\\S*?[@#$%^&+=])\\\\S{8,}\\\\z\"");
    private static final String SIGN_UP_QUERY = "INSERT INTO users (name, nameId, email, password) VALUES (?, ?, ?, ?)";

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
        return false;
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
        return null;
    }

    @Override
    public boolean setSession(Session session) {
        return false;
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
        return false;
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
            ps.setString(0, name);
            ps.setString(1, nameId);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.fillInStackTrace();
            logger.log(Level.SEVERE, "% AUTH SERVICES ERROR: %s", e);
        };

        return true;
    }

    @Override
    public void logout() {

    }
}
