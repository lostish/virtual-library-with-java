package sh.losti.app.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseEnviroment {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static String getDbUrl() {
        return dotenv.get("DB_URL");
    }

    public static String getDbUser() {
        return dotenv.get("DB_USER");
    }

    public static String getDbPwd() {
        return dotenv.get("DB_PWD");
    }
}
