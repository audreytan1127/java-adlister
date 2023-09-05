CREATE DATABASE adlister_db;
USE adlister_db;

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
                                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                        name VARCHAR(255) NOT NULL,
                                        email VARCHAR(100) NOT NULL UNIQUE,
                                        password VARCHAR(50) NOT NULL,
                                        PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads (
                                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     user_id INT unsigned NOT NULL,
                                     title VARCHAR(100) NOT NULL,
                                     description TEXT NULL,
                               PRIMARY KEY (id),
                               FOREIGN KEY (user_id) REFERENCES users(id)
);