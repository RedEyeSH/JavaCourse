DROP DATABASE IF EXISTS CurrencyDB;
CREATE DATABASE CurrencyDB;
USE CurrencyDB;

CREATE TABLE Currency (
    id INT AUTO_INCREMENT PRIMARY KEY,
    abbreviation VARCHAR(3) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    exchange_rate DECIMAL(10, 2) NOT NULL
);

INSERT INTO Currency (abbreviation, name, exchange_rate) VALUES
('EUR', 'Euro', 1.00),
('USD', 'United States Dollar', 1.05),
('GBP', 'British Pound', 0.83),
('JPY', 'Japanese Yen', 157.60),
('AUD', 'Australian Dollar', 1.68),
('CAD', 'Canadian Dollar', 1.51),
('CHF', 'Swiss Franc', 0.94),
('CNY', 'Chinese Yuan', 7.64);

GRANT SELECT, INSERT, UPDATE, DELETE ON CurrencyDB.* TO 'root'@'localhost';

FLUSH PRIVILEGES;
