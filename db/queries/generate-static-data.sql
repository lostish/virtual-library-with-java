USE vlwj;
GO

-- USERS
INSERT INTO users (name, name_id, email, password, state, role)
VALUES 
('Alice Smith', 'alice-smith', 'alice@example.com', 'hashed_pw1', 'ACTIVE', 'USER'),
('Bob Johnson', 'bob-johnson', 'bob@example.com', 'hashed_pw2', 'ACTIVE', 'HELPER'),
('Carol Lee', 'carol-lee', 'carol@example.com', 'hashed_pw3', 'INACTIVE', 'USER'),
('David Kim', 'david-kim', 'david@example.com', 'hashed_pw4', 'ACTIVE', 'ADMIN'),
('Eve Clark', 'eve-clark', 'eve@example.com', 'hashed_pw5', 'ACTIVE', 'USER'),
('Frank Wright', 'frank-wright', 'frank@example.com', 'hashed_pw6', 'DELETED', 'USER'),
('Grace Hall', 'grace-hall', 'grace@example.com', 'hashed_pw7', 'INACTIVE', 'HELPER'),
('Henry Young', 'henry-young', 'henry@example.com', 'hashed_pw8', 'ACTIVE', 'USER'),
('Ivy Green', 'ivy-green', 'ivy@example.com', 'hashed_pw9', 'ACTIVE', 'USER'),
('Jack Black', 'jack-black', 'jack@example.com', 'hashed_pw10', 'INACTIVE', 'USER');

-- EDITORIALS
INSERT INTO editorials (name, nameId, description, avatar)
VALUES 
('Sunrise Publishing', 'sunrise-pub', 'Editorial de novelas románticas.', NULL),
('Moonlight Books', 'moonlight-books', 'Fantasía épica y ciencia ficción.', NULL),
('Shadow Works', 'shadow-works', 'Misterio y suspenso.', NULL),
('Oceanic Tales', 'oceanic-tales', 'Historias ambientadas en el mar.', NULL),
('Nova House', 'nova-house', 'Editorial juvenil.', NULL),
('Echo Press', 'echo-press', 'Literatura experimental.', NULL),
('Crimson Ink', 'crimson-ink', 'Terror psicológico.', NULL),
('Emerald Leaf', 'emerald-leaf', 'Libros ecológicos.', NULL),
('Golden Words', 'golden-words', 'Premios literarios.', NULL),
('Steel Quill', 'steel-quill', 'Historias de guerra.', NULL);

-- EDITORIAL GENRES
INSERT INTO editorial_genres (editorial_id, genre)
VALUES 
(1, 'Romance'), (1, 'Drama'),
(2, 'Fantasía'), (2, 'Sci-Fi'),
(3, 'Thriller'), (3, 'Detective'),
(4, 'Aventura'), (5, 'Juvenil'),
(6, 'Experimental'), (7, 'Terror');

-- AUTHORS
INSERT INTO authors (user_id, editorial_id)
VALUES 
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10);

-- AUTHOR GENRES
INSERT INTO author_genres (author_id, genre)
VALUES 
(1, 'Romance'), (2, 'Sci-Fi'), (3, 'Thriller'),
(4, 'Aventura'), (5, 'Juvenil'), (6, 'Poesía'),
(7, 'Terror'), (8, 'Naturaleza'), (9, 'Historia'),
(10, 'Acción');

-- BOOKS
INSERT INTO books (author_id, name, nameId, description, published, download_type)
VALUES 
(1, 'Sunset Love', 'sunset-love', 'Una historia de amor en la playa.', 1, 'OPEN'),
(2, 'Galactic War', 'galactic-war', 'Batallas entre galaxias.', 1, 'PAID'),
(3, 'Dark Alley', 'dark-alley', 'Crimen en la ciudad.', 0, 'MEMBERS_ONLY'),
(4, 'Ocean Voyage', 'ocean-voyage', 'Viaje por el océano.', 1, 'OPEN'),
(5, 'Teenage World', 'teenage-world', 'Vida adolescente.', 0, 'OPEN'),
(6, 'Echoes', 'echoes', 'Literatura abstracta.', 1, 'PAID'),
(7, 'Crimson Night', 'crimson-night', 'Terror en la noche.', 1, 'OPEN'),
(8, 'Green Earth', 'green-earth', 'Historias ecológicas.', 0, 'OPEN'),
(9, 'Gold Rush', 'gold-rush', 'Historia y fortuna.', 1, 'MEMBERS_ONLY'),
(10, 'Iron Valor', 'iron-valor', 'Relatos de guerra.', 1, 'PAID');

-- BOOK POST
INSERT INTO book_post (book_id, book_resource_id, title, chapter_number)
VALUES 
(1,  1, 'Mis lecturas favoritas', 2560),
(2,  2, 'Crítica a "Galactic War"', 7000),
(3,  3, 'Reflexión sobre el terror', 6000),
(4,  4, 'Cómo escribir mejor', 3000),
(5,  5, 'Recomendaciones juveniles', 650),
(6,  6, 'Mi primer libro publicado', 400),
(7,  7, 'Libros y salud mental', 200),
(8,  8, 'Amor y literatura', 1584),
(9,  9, 'Autopublicación en 2025', 600),
(10, 10,  'Consejos para nuevos autores', 300);

-- BOOK RESOURCE
INSERT INTO book_resource (book_post_id, resource_type, book_resource_url)
VALUES 
(1, 'PDF', '/WEB-INF/resources/books/sunset-love.pdf'),
(2, 'PDF', '/WEB-INF/resources/books/galactic-war.pdf'),
(3, 'PDF', '/WEB-INF/resources/books/dark-alley.pdf'),
(4, 'PDF', '/WEB-INF/resources/books/ocean-voyage.pdf'),
(5, 'PDF', '/WEB-INF/resources/books/teenage-world.pdf'),
(6, 'PDF', '/WEB-INF/resources/books/echoes.pdf'),
(7, 'PDF', '/WEB-INF/resources/books/crimson-night.pdf'),
(8, 'PDF', '/WEB-INF/resources/books/green-earth.pdf'),
(9, 'PDF', '/WEB-INF/resources/books/gold-rush.pdf'),
(10,'PDF', '/WEB-INF/resources/books/iron-valor.pdf');

-- BOOK STATS
INSERT INTO book_stats (book_id, book_post_id, views, saves, downloads, completed, comments, average_rating)
VALUES
(1, 1, 250, 40, 200, 180, 25, 4.7),
(2, 2, 520, 120, 430, 400, 60, 4.9),
(3, 3, 180, 25, 150, 140, 12, 4.5),
(4, 300, 220, 75, 15, 150, 80, 64.05),
(5, 80, 50, 25, 5, 35, 75, 13.25),
(6, 220, 180, 50, 10, 75, 64, 22.44),
(7, 400, 350, 110, 20, 80, 55, 90.90),
(8, 60, 30, 20, 4, 78, 656, 20),
(9, 170, 140, 55, 12, 98, 54, 31),
(10, 310, 280, 95, 18, 265, 12, 214.06);


-- COMMENT
INSERT INTO comment (user_id, post_id, body)
VALUES
(2, 1, 'Me encantó este libro, muy inspirador.'),
(3, 2, 'Una obra compleja pero fascinante.'),
(1, 3, 'Excelente reflexión sobre la vida.'),
(4, 5, 'Relajante y aventurera.'),
(5, 6, 'Perfecta para adolescentes.'),
(6, 7, 'Muy profunda y reflexiva.'),
(7, 8, 'Me dio miedo de verdad.'),
(8, 9, 'Conciencia ecológica, gran libro.'),
(9, 10, 'Me atrapó la historia.'),
(10, 4, 'Impresionante relato bélico.');

-- SESSION
INSERT INTO session (user_id, session_key, expires_at)
VALUES
(1, 'abc123session', DATEADD(DAY, 1, SYSUTCDATETIME())),
(2, 'def456session', DATEADD(DAY, 1, SYSUTCDATETIME()));

-- SESSION_DATA
INSERT INTO session_data (session_data_id, session_name, session_name_id, session_email)
VALUES
(1, 'Carlos Ruiz', 'carlos-ruiz', 'carlos@example.com'),
(2, 'Lucía Torres', 'lucia-torres', 'lucia@example.com');

-- PROFILES
INSERT INTO profiles (user_id, last_work_name_id, editorial_name_id, biography)
VALUES
(1, 'el-arte-de-ser-feliz-autor-arthur-schopenhauer', 'editorial-sur', 'Filósofo existencial.'),
(2, 'cien-anos-de-soledad-autor-gabriel-garcia-marquez', 'mundo-letras', 'Apasionada por la narrativa mágica.');

-- PROFILE_BOOKMARK
INSERT INTO profile_bookmark (profile_id, book_post_id, profile_bookmark_type)
VALUES
(1, 2, 'FAVORITE'),
(2, 1, 'COMPLETED');

-- PROFILE_NETWORK
INSERT INTO profile_network (profile_id, network_name, network_type, network_url)
VALUES
(1, 'DISCORD', 'SOCIAL', 'https://discord.com/users/carlos'),
(2, 'DISCORD', 'SOCIAL', 'https://discord.com/users/lucia');

-- USER_BOOK_INTERACTIONS
INSERT INTO user_book_interactions (user_id, book_id, interaction_type)
VALUES
(1, 2, 'favorite'),
(2, 1, 'bookmark'),
(2, 3, 'bookmark');

-- LOGS
INSERT INTO logs (level, create_by, action, message, data, errors, location, duration)
VALUES
('INFO', 'SYSTEM', 'INIT_DB', 'Base de datos inicializada con datos prehechos.', NULL, NULL, 'init.sql', 2),
('FINE', 'Carlos Ruiz', 'INSERT_BOOK', 'Libro agregado correctamente.', 'book_id=1', NULL, '/account/upload', 1),
('WARNING', 'Lucía Torres', 'FAILED_LOGIN', 'Usuario ingresó contraseña incorrecta.', NULL, 'Credenciales inválidas', '/auth/sign-in', 0);
