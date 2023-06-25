CREATE DATABASE IF NOT EXISTS system_school;

USE system_school;

CREATE TABLE IF NOT EXISTS Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(20),
    paymentStatus INT,
    creationDate DATETIME,
    grade DECIMAL(2, 2)
);

CREATE TABLE IF NOT EXISTS Teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    age INT,
    salary DECIMAL(10,2),
    address VARCHAR(20),
    graduation VARCHAR(10),
    creationDate DATETIME
);

CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(10),
    password VARCHAR(10),
    creationDate DATETIME
);