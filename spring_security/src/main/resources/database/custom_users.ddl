CREATE DATABASE IF NOT EXISTS spring_security;

USE spring_security;

CREATE TABLE customers (
                       id INT NOT NULL AUTO_INCREMENT,
                       email VARCHAR(50) NOT NULL ,
                       pwd VARCHAR(500) NOT NULL,
                       role VARCHAR(500) NOT NULL,
                       PRIMARY KEY (id)
);
INSERT IGNORE INTO customers VALUES (NULL, 'manish.chauhan@ushatech.in', '12345', 'user');