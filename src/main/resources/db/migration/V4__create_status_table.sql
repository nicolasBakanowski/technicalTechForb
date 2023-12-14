CREATE TABLE IF NOT EXISTS status (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(20) UNIQUE NOT NULL
);

INSERT INTO status (status_name) VALUES ('pendiente');
INSERT INTO status (status_name) VALUES ('realizado');
INSERT INTO status (status_name) VALUES ('cancelado');
INSERT INTO status (status_name) VALUES ('rechazado');