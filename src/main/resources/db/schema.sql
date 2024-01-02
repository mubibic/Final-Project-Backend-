#  This is the SQL script to create the database and tables for the Asset Management System
-- Create the database
CREATE DATABASE IF NOT EXISTS AGCDB;

-- Use the database ???
USE AGCDB;

CREATE TABLE inventory_in_stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    model VARCHAR(255),
    extra_information VARCHAR(255),
    location VARCHAR(255),
    quantity INT
);

CREATE TABLE asset_disposal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    serial_number VARCHAR(255),
    extra_information VARCHAR(255),
    disposal_date VARCHAR(255),
    disposal_reason VARCHAR(255)
);

CREATE TABLE disposed_asset_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    serial_number VARCHAR(255),
    extra_information VARCHAR(255),
    disposal_date VARCHAR(255),
    disposal_reason VARCHAR(255)
);

CREATE TABLE login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    name VARCHAR(255)
);


