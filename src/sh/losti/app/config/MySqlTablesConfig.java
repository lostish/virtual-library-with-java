package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class MySqlTablesConfig implements ITablesConfig {
    @Override
    public String getEditorialsTable() {
        return """
                CREATE TABLE IF NOT EXISTS editorials (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    nameId VARCHAR(255) NOT NULL UNIQUE,
                    description TEXT,
                    avatar VARCHAR(512),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
                );
               """;
    }

    @Override
    public String getEditorialsGenreTable() {
        return """
                CREATE TABLE IF NOT EXISTS editorial_genres (
                    editorial_id INT NOT NULL,
                    genre VARCHAR(255) NOT NULL,
                    PRIMARY KEY (editorial_id, genre),
                    FOREIGN KEY (editorial_id) REFERENCES editorials(id)
                );
               """;
    }

    @Override
    public String getAuthorsTable() {
        return """
                CREATE TABLE IF NOT EXISTS authors (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    nameId VARCHAR(255) NOT NULL UNIQUE,
                    description TEXT,
                    imageUrl VARCHAR(512),
                    last_work_id VARCHAR(64),
                    editorial_id INT,
                    FOREIGN KEY (editorial_id) REFERENCES editorials(id)
                );
               """;
    }

    @Override
    public String getAuthorsGenreTable() {
        return """
                CREATE TABLE IF NOT EXISTS author_genres (
                    author_id INT NOT NULL,
                    genre VARCHAR(255) NOT NULL,
                    PRIMARY KEY (author_id, genre),
                    FOREIGN KEY (author_id) REFERENCES authors(id)
                );
               """;
    }

    @Override
    public String getBooksTable() {
        return """
                CREATE TABLE IF NOT EXISTS books (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    nameId VARCHAR(255) NOT NULL UNIQUE,
                    description TEXT,
                    biography TEXT,
                    published BOOLEAN NOT NULL DEFAULT FALSE,
                    editorial_id INT,
                    views INT DEFAULT 0,
                    saves INT DEFAULT 0,
                    downloads INT DEFAULT 0,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                    FOREIGN KEY (editorial_id) REFERENCES editorials(id)
                );
               """;
    }

    @Override
    public String getUsersTable() {
        return """
                CREATE TABLE IF NOT EXISTS users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       nameId VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
                   );
               """;
    }

    @Override
    public String getSessionsTable() {
        return """
                CREATE TABLE IF NOT EXISTS sessions (
                    session_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                    user_id INT NOT NULL,
                    session_key VARCHAR(255) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    expires_at TIMESTAMP NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(id)
                )
               """;
    }

    @Override
    public String getProfilesTable() {
        return """
                CREATE TABLE IF NOT EXISTS profiles (
                    id VARCHAR(64) PRIMARY KEY,
                    user_id INT NOT NULL,
                    biography TEXT,
                    networks TEXT,
                    books TEXT,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                    FOREIGN KEY (user_id) REFERENCES users(id)
                );
               """;
    }

    @Override
    public String getBookInteractionTable() {
        return """
                CREATE TABLE IF NOT EXISTS user_book_interactions (
                    user_id INT NOT NULL,
                    book_id INT NOT NULL,
                    interaction_type ENUM('bookmark', 'favorite') NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    PRIMARY KEY (user_id, book_id, interaction_type),
                    FOREIGN KEY (user_id) REFERENCES users(id),
                    FOREIGN KEY (book_id) REFERENCES books(id)
                );
               """;
    }

    @Override
    public String getLogsTable() {
        return """
                CREATE IF NOT EXISTS logs (
                    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                    level ENUM('FINE', 'SEVERE', 'CONFIG', 'ALL', 'INFO', 'WARNING', 'ERROR', 'DATABASE') NOT NULL,
                    by CHAR(255) NOT NULL,
                    action CHAR(255) NOT NULL,
                    message VARCHAR NOT NULL,
                    data VARCHAR,
                    errors VARCHAR,
                    location VARCHAR,
                    duration INTEGER NOT NULL DEFAULT 0,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                )
                """;
    }
}
