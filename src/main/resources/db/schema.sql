
-- Create the database
CREATE DATABASE IF NOT EXISTS AGCDB;

-- Use the database
USE AGCDB;

-- Create the current_inventory table
CREATE TABLE current_inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    hdd_serial_number VARCHAR(255) NOT NULL,
    extra_information VARCHAR(255)
);

-- Create the disposal_inventory table
CREATE TABLE disposal_inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    current_inventory_id INT,
    FOREIGN KEY (current_inventory_id) REFERENCES current_inventory(id),
    disposal_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    disposal_reason TEXT
);