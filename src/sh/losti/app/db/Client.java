package sh.losti.app.db;

import sh.losti.app.config.TablesConfig;
import sh.losti.app.interfaces.config.ITablesConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());
    //private static final boolean initialized = false;

    private Client() {
    }

    /*
    public static synchronized void ensureInitialized() {
        if (!initialized) {
            try {
                mountTablesConfig();
                initialized = true;
                logger.info("✅ Tablas montadas correctamente.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "❌ Error montando tablas al inicializar", e);
            }
        }
    }
    */

    public static Connection getConnection() throws SQLException {
        // Usign SQL SERVER JDBC Driver
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PWD");

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("Las variables de entorno de la base de datos no están configuradas.");
        }

        return DriverManager.getConnection(url, user, password);
    }

    public static void mountTablesConfig() throws SQLException {
        try (Statement stm = getStatement()) {
            ITablesConfig config = TablesConfig.sqlite();

            stm.addBatch(config.getLogsTable());
            stm.addBatch(config.getUsersTable());
            stm.addBatch(config.getProfilesTable());
            stm.addBatch(config.getBookInteractionTable());
            stm.addBatch(config.getEditorialsTable());
            stm.addBatch(config.getEditorialsGenreTable());
            stm.addBatch(config.getAuthorsTable());
            stm.addBatch(config.getSessionsTable());
            stm.addBatch(config.getAuthorsGenreTable());
            stm.addBatch(config.getBooksTable());

            stm.executeBatch();
            stm.clearBatch();
            stm.close();

            logger.log(Level.FINE, "% Se ha montado la configuraciòn de tablas");
        } catch (SQLException e) {
            e.fillInStackTrace();
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /*
     * - prevents SQL injection attacks
     * - previene ataques de SQL inyección
     */
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        try (Connection conn = getConnection()) {
            AtomicReference<PreparedStatement> ps = new AtomicReference<>(conn.prepareStatement(sql));
            return ps.get();
        } catch (SQLException e) {
            e.fillInStackTrace();
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * - Statement is unsafe with SQL injections, but fast to handle multiple objects.
     * @return Statement stat
     * @throws SQLException
     */

    public static Statement getStatement() throws SQLException {
        try (Connection conn = getConnection()) {
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
