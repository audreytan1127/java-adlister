CREATE DATABASE adlister_db;
USE adlister_db;
CREATE USER 'adlister_user'@'localhost:3306' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON adlister_db TO 'adlister_user'@'localhost:3306';

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
                                        id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        email VARCHAR(100) NOT NULL UNIQUE,
                                        password VARCHAR(50) NOT NULL,
                                        PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads (
                                     id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     user_id INT UNSIGNED NOT NULL,
                                     title VARCHAR(100) NOT NULL,
                                     description TEXT NULL,
                               PRIMARY KEY (id),
                               CONSTRAINT users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);