DROP DATABASE spring_security;

CREATE DATABASE IF NOT EXISTS spring_security;

USE spring_security;

CREATE TABLE users (
                        id INT NOT NULL AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL ,
                       password VARCHAR(500) NOT NULL,
                       enabled BOOLEAN NOT NULL,
    PRIMARY KEY (id),
                        INDEX idx_username (username)  -- Adding index to the username column
);

CREATE TABLE authorities (
                             id INT NOT NULL AUTO_INCREMENT,
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                            primary key (id),
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);
-- In MySQL, when you create a foreign key constraint, the referenced column(s)
-- must be indexed. In your case, the username column in the users table,
-- which is referenced by the fk_authorities_users constraint, needs to be indexed.
INSERT IGNORE INTO users VALUES (NULL, 'happy', '12345', 'true');
INSERT IGNORE INTO authorities VALUES (NULL, 'happy', 'write');