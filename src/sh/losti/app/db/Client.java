package sh.losti.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Client {

    private Client() {
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PWD");

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("Las variables de entorno de la base de datos no están configuradas.");
        }

        return DriverManager.getConnection(url, user, password);
    }
}
