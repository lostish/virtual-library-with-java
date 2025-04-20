package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class SQLiteTablesConfig implements ITablesConfig {
    @Override
    public String getEditorialsTable() {
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
    public String getEditorialsGenreTable() {
        return """
                 CREATE TABLE IF NOT EXISTS editorial_genres (
                     editorial_id INTEGER NOT NULL,
                     genre TEXT NOT NULL,
                     PRIMARY KEY (editorial_id, genre),
                     FOREIGN KEY (editorial_id) REFERENCES editorials(id)
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
    public String getAuthorsGenreTable() {
        return """
                 CREATE TABLE IF NOT EXISTS author_genres (
                     author_id INTEGER NOT NULL,
                     genre TEXT NOT NULL,
                     PRIMARY KEY (author_id, genre),
                     FOREIGN KEY (author_id) REFERENCES authors(id)
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
    public String getSessionsTable() {
        return """
                CREATE TABLE IF NOT EXISTS sessions (
                 session_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                 user_id INTEGER NOT NULL,
                 session_key TEXT NOT NULL,
                 created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                 expires_at TEXT NOT NULL,
                 FOREIGN KEY (user_id) REFERENCES users(id)
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
    public String getBookInteractionTable() {
        return """
                 CREATE TABLE IF NOT EXISTS user_book_interactions (
                     user_id INTEGER NOT NULL,
                     book_id INTEGER NOT NULL,
                     interaction_type TEXT NOT NULL CHECK(interaction_type IN ('bookmark', 'favorite')),
                     created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                     PRIMARY KEY (user_id, book_id, interaction_type),
                     FOREIGN KEY (user_id) REFERENCES users(id),
                     FOREIGN KEY (book_id) REFERENCES books(id)
                 );
                """;
    }

    @Override
    public String getLogsTable() {
        return """
                CREATE TABLE IF NOT EXISTS logs (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    by TEXT NOT NULL,
                    where TEXT NOT NULL,
                    handler TEXT NOT NULL,
                    data TEXT,
                    errors TEXT,
                    duration INTEGER NOT NULL DEFAULT 0,
                    created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                )
                """;
    }
}
