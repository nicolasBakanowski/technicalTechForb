
CREATE TABLE IF NOT EXISTS menuoptions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    option_name VARCHAR(255) NOT NULL
);

INSERT INTO menuoptions (option_name) VALUES ('inicio');
INSERT INTO menuoptions (option_name) VALUES ('tarjetas');
INSERT INTO menuoptions (option_name) VALUES ('prestamos');
INSERT INTO menuoptions (option_name) VALUES ('operaciones');

