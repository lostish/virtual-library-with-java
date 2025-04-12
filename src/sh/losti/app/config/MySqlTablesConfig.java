package sh.losti.app.config;

import sh.losti.app.interfaces.config.ITablesConfig;

public class MySqlTablesConfig implements ITablesConfig {
    @Override
    public String getEditorsTable() {
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
    public String getBookmarksTable() {
        return "";
    }
}
