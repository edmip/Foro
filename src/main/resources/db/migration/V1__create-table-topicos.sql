



CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(300) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estatus INTEGER(2) NOT NULL,
    autor VARCHAR(6) NOT NULL,
    curso VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);