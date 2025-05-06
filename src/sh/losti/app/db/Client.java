package sh.losti.app.db;

import sh.losti.app.config.DatabaseEnviroment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    private Client() {}

    public static Connection getConnection() throws SQLException {
        // Usign SQL SERVER JDBC Driver
        String url = DatabaseEnviroment.getDbUrl();
        String user = DatabaseEnviroment.getDbUser();
        String password = DatabaseEnviroment.getDbPwd();

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("Las variables de entorno de la base de datos no están configuradas.");
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    /*
     * - prevents SQL injection attacks
     * - previene ataques de SQL inyección
     */
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection conn = getConnection(); // Conexión NO se cierra aquí
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            conn.close(); // Cierra si hay error al crear el PreparedStatement
            throw e;
        }
    }

    /**
     * - Statement is unsafe with SQL injections, but fast to handle multiple objects.
     * @return Statement stat
     * @throws SQLException
     */

    public static Statement getStatement() throws SQLException {
        Connection conn = getConnection();
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
