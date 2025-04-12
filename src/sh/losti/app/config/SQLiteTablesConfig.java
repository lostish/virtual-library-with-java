package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class SQLiteTablesConfig implements ITablesConfig {
    @Override
    public String getEditorsTable() {
        return """
               CREATE TABLE IF NOT EXISTS editorials (
                   id INTEGER PRIMARY KEY AUTOINCREMENT,
                   name TEXT NOT NULL,
                   nameId TEXT NOT NULL UNIQUE,
                   description TEXT,
                   avatar TEXT,
                   created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                   updated_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
               );
               """;
    }

    @Override
    public String getAuthorsTable() {
        return """
               CREATE TABLE IF NOT EXISTS authors (
                   id INTEGER PRIMARY KEY AUTOINCREMENT,
                   name TEXT NOT NULL,
                   nameId TEXT NOT NULL UNIQUE,
                   description TEXT,
                   imageUrl TEXT,
                   last_work_id TEXT,
                   editorial_id INTEGER,
                   FOREIGN KEY (editorial_id) REFERENCES editorials(id)
               );
             """;
    }

    @Override
    public String getBooksTable() {
        return """
                CREATE TABLE IF NOT EXISTS books (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    nameId TEXT NOT NULL UNIQUE,
                    description TEXT,
                    biography TEXT,
                    published INTEGER NOT NULL DEFAULT 0,
                    editorial_id INTEGER,
                    views INTEGER DEFAULT 0,
                    saves INTEGER DEFAULT 0,
                    downloads INTEGER DEFAULT 0,
                    created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                    updated_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (editorial_id) REFERENCES editorials(id)
                );
               """;
    }

    @Override
    public String getUsersTable() {
        return """
               CREATE TABLE IF NOT EXISTS users (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  name TEXT NOT NULL,
                  nameId TEXT NOT NULL UNIQUE,
                  email TEXT NOT NULL UNIQUE,
                  password TEXT NOT NULL,
                  created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                  updated_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
               );
               """;
    }

    @Override
    public String getProfilesTable() {
        return """
               CREATE TABLE IF NOT EXISTS profiles (
                   id INTEGER PRIMARY KEY AUTOINCREMENT,
                   user_id INTEGER NOT NULL,
                   biography TEXT,
                   networks TEXT,
                   books TEXT,
                   created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                   updated_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                   FOREIGN KEY (user_id) REFERENCES users(id)
               );
               """;
    }

    @Override
    public String getBookmarksTable() {
        return "";
    }
}
