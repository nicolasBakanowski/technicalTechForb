CREATE TABLE IF NOT EXISTS typedocument (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL
);

INSERT INTO typedocument (type_name) VALUES ('DNI');
INSERT INTO typedocument (type_name) VALUES ('PASAPORTE');
INSERT INTO typedocument (type_name) VALUES ('CEDULON');
