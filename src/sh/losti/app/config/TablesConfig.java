package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class TablesConfig {
    // EN-TODO: Define the tables to be generated automatically
    // ES-TODO: Definir las tablas a generar automaticamente
    private TablesConfig() {}

    public static ITablesConfig sqlite() {
        return new SQLiteTablesConfig();
    }

    public static ITablesConfig mysql() {
        return new MySqlTablesConfig();
    }
}
