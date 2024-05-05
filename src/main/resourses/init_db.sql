-- Create Database
CREATE DATABASE IF NOT EXISTS taxiservice;

-- Use the Database
USE taxiservice;

-- Create manufacturers table
CREATE TABLE IF NOT EXISTS manufacturers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);

-- Create drivers table
CREATE TABLE IF NOT EXISTS drivers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    license_number VARCHAR(255) NOT NULL UNIQUE,
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create cars table
CREATE TABLE IF NOT EXISTS cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    manufacturer_id INT,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id)
);

-- Create cars_drivers table (many-to-many relationship)
CREATE TABLE IF NOT EXISTS cars_drivers (
    car_id INT,
    driver_id INT,
    PRIMARY KEY (car_id, driver_id),
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE,
    FOREIGN KEY (driver_id) REFERENCES drivers(id) ON DELETE CASCADE
);
