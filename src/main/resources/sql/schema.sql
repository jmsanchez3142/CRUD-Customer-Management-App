-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS db_customer_management;

-- Seleccionar la base de datos
USE db_customer_management;

-- Crear la tabla 'customers'
CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15)
);

-- Insertar registros de ejemplo
INSERT INTO customers (name, email, phone) VALUES
    ('Juan Pérez', 'juanperez@example.com', '+34612345678'),
    ('María García', 'mariagarcia@example.com', '+34987654321'),
    ('José Martínez', 'josemartinez@example.com', '+34678901234');
