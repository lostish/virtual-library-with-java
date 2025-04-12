package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class TablesConfig {
    // EN-SUMMARY: Method factory for SQLite like MySQL
    // ES-SUMMARY: Fábrica de métodos para SQLite como MySQL
    private TablesConfig() {}

    public static ITablesConfig sqlite() {
        return new SQLiteTablesConfig();
    }

    public static ITablesConfig mysql() {
        return new MySqlTablesConfig();
    }
}
