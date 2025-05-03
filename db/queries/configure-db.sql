USE MASTER;
GO

-- 1. Creación de la base de datos

CREATE DATABASE vlwj;
GO

USE vlwj;
GO

-- 2. Eliminación de tablas existentes (orden inverso a dependencias)

-- Primero eliminar tablas con más dependencias (las que tienen claves foráneas)
DROP TABLE IF EXISTS logs;
DROP TABLE IF EXISTS user_book_interactions;
DROP TABLE IF EXISTS profile_network;
DROP TABLE IF EXISTS profile_bookmark;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS session_data;
DROP TABLE IF EXISTS session;
DROP TABLE IF EXISTS book_stats;
DROP TABLE IF EXISTS book_resource;
DROP TABLE IF EXISTS book_post;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS author_genres;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS editorial_genres;
DROP TABLE IF EXISTS books;
GO

-- Luego eliminar tablas base (las que son referenciadas)
DROP TABLE IF EXISTS editorials;
DROP TABLE IF EXISTS users;
GO

-- 3. Creación de tablas (orden de dependencias)

-- Tabla base: usuarios
CREATE TABLE users (
    user_id         INT IDENTITY(1,1) PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    name_id         VARCHAR(255) NOT NULL UNIQUE,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    state           CHAR(8) CHECK(state IN('ACTIVE', 'INACTIVE', 'DELETED')) NOT NULL DEFAULT 'INACTIVE',
    role            CHAR(6) CHECK(role IN('ADMIN', 'HELPER', 'USER')) NOT NULL DEFAULT 'USER',
    last_login      DATETIME2 NOT NULL,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME()
);

-- Tabla: editoriales
CREATE TABLE editorials (
    editorial_id    INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    name            VARCHAR(255) NOT NULL,
    nameId          VARCHAR(255) NOT NULL UNIQUE,
    description     TEXT,
    avatar          VARCHAR(512),
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME()
);

-- Tabla: géneros de editoriales
CREATE TABLE editorial_genres (
    editorial_id    INT NOT NULL,
    genre           VARCHAR(255) NOT NULL,
    PRIMARY KEY (editorial_id, genre),
    FOREIGN KEY (editorial_id) REFERENCES editorials(editorial_id)
);

-- Tabla: autores (depende de usuarios y editoriales)
CREATE TABLE authors (
    id              INT IDENTITY(1,1) PRIMARY KEY,
    user_id         INT NOT NULL,
    last_work_id    INT,
    editorial_id    INT,
    FOREIGN KEY (user_id)      REFERENCES users(user_id),
    FOREIGN KEY (editorial_id) REFERENCES editorials(editorial_id)
);

-- Tabla: géneros de autores
CREATE TABLE author_genres (
    author_id       INT NOT NULL,
    genre           VARCHAR(255) NOT NULL,
    PRIMARY KEY (author_id, genre),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

-- Tabla: libros (depende de autores)
CREATE TABLE books (
    id              INT IDENTITY(1,1) PRIMARY KEY,
    author_id       INT NOT NULL,
    name            VARCHAR(255) NOT NULL,
    nameId          VARCHAR(255) NOT NULL UNIQUE,
    description     VARCHAR(MAX),
    published       BIT NOT NULL DEFAULT 0,
    state           CHAR(8) NOT NULL CHECK(state IN('EMISSION', 'HIATUS', 'DROPPED', 'FINISHED')) DEFAULT 'EMISSION',
    post_type       CHAR(18) NOT NULL CHECK(post_type IN(
        'UNIQUE_EDITION', 'SAGA', 'SERIES', 'ANTHOLOGY', 'SERIAL_EDITION', 
        'SINGLE_ISSUE', 'TRADE_PAPERBACK', 'TPB', 'STORY_ARC', 'HARDCOVER',
        'COMPILATION_VOLUME', 'WEB_COMIC', 'WEB_TOON', 'WEEKLY_POST', 
        'MONTHLY_POST', 'ONE_SHOT'
    )) DEFAULT 'WEEKLY_POST',
    download_type   CHAR(12) CHECK(download_type IN('OPEN', 'MEMBERS_ONLY', 'PAID')) DEFAULT 'OPEN' NOT NULL,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

-- Tabla: posts de libros
CREATE TABLE book_post (
    book_post_id    INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    book_id         INT NOT NULL,
    book_resource_id INT NOT NULL,
    chapter_number  INT,
    title           CHAR,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Tabla: recursos de libros
CREATE TABLE book_resource (
    book_resource_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    book_post_id     INT NOT NULL,
    book_resource_url VARCHAR(MAX),
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (book_post_id) REFERENCES book_post(book_post_id)
);

-- Tabla: estadísticas de libros
CREATE TABLE book_stats (
    book_stats_id   INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    book_id         INT,
    book_post_id    INT,
    views           INT NOT NULL DEFAULT 0,
    saves           INT NOT NULL DEFAULT 0,
    downloads       INT NOT NULL DEFAULT 0,
    completed       INT NOT NULL DEFAULT 0,
    comments        INT NOT NULL DEFAULT 0,
    average_rating  FLOAT NOT NULL DEFAULT 0.0,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (book_post_id) REFERENCES book_post(book_post_id)
);

-- Tabla: comentarios
CREATE TABLE comment (
    comment_id      INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    user_id         INT NOT NULL,
    post_id         INT NOT NULL,
    body            VARCHAR(MAX) NOT NULL,
    resources       VARCHAR(MAX),
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tabla: sesiones de usuario
CREATE TABLE session (
    session_id      INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    user_id         INT NOT NULL,
    session_key     VARCHAR(255) NOT NULL,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    expires_at      DATETIME2 NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tabla: datos de sesión
CREATE TABLE session_data (
    session_data_id INT NOT NULL,
    session_name    VARCHAR(MAX) NOT NULL,
    session_name_id VARCHAR(MAX) NOT NULL,
    session_email   VARCHAR(MAX) NOT NULL
);

-- Tabla: perfiles de usuario
CREATE TABLE profiles (
    id              INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    user_id         INT NOT NULL,
    last_work_name_id VARCHAR(MAX),
    editorial_name_id VARCHAR(MAX),
    biography       VARCHAR(MAX),
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tabla: marcadores de perfil
CREATE TABLE profile_bookmark (
    profile_bookmar_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    profile_id      INT NOT NULL,
    book_post_id    INT NOT NULL,
    profile_bookmark_type CHAR(9) CHECK(profile_bookmark_type IN(
        'COMPLETED', 'FAVORITE', 'PENDING', 'DROPPED'
    )) NOT NULL DEFAULT 'PENDING',
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    updated_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    FOREIGN KEY (profile_id) REFERENCES profiles(id),
    FOREIGN KEY (book_post_id) REFERENCES book_post(book_post_id)
);

-- Tabla: redes de perfil
CREATE TABLE profile_network(
    profile_id      INT NOT NULL,
    network_name    VARCHAR(64) CHECK(network_name IN('DISCORD', 'UNDEFINED')) NOT NULL DEFAULT 'UNDEFINED',
    network_type    CHAR(16) CHECK(network_type IN('NONE', 'SOCIAL', 'WORK')) NOT NULL DEFAULT 'NONE',
    network_url     VARCHAR(255) NOT NULL,
    FOREIGN KEY (profile_id) REFERENCES profiles(id)
);

-- Tabla: interacciones usuario-libro
CREATE TABLE user_book_interactions (
    user_id         INT NOT NULL,
    book_id         INT NOT NULL,
    interaction_type VARCHAR(10) NOT NULL CHECK(interaction_type IN('bookmark', 'favorite')),
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME(),
    PRIMARY KEY (user_id, book_id, interaction_type),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Tabla: logs del sistema
CREATE TABLE logs (
    id              INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    level           CHAR(8) NOT NULL CHECK(level IN('FINE', 'SEVERE', 'CONFIG', 'ALL', 'INFO', 'WARNING', 'ERROR', 'DATABASE')),
    create_by       CHAR(255) NOT NULL,
    action          CHAR(255) NOT NULL,
    message         VARCHAR(MAX) NOT NULL,
    data            VARCHAR(MAX),
    errors          VARCHAR(MAX),
    location        VARCHAR(MAX),
    duration        INTEGER NOT NULL DEFAULT 0,
    created_at      DATETIME2 DEFAULT SYSUTCDATETIME()
);

GO