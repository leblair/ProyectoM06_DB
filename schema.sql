CREATE TABLE entrenadores (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(255) NOT NULL,
     age int NOT NULL,
     med1 CHAR(255),
     med2 CHAR(255),
     med3 CHAR(255),
     med4 CHAR(255),
     med5 CHAR(255),
     med6 CHAR(255),
     med7 CHAR(255),
     med8 CHAR(255),
     PRIMARY KEY (id)
);

CREATE TABLE pokemons (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(255) NOT NULL,
     tipo_principal CHAR(255) NOT NULL,
     tipo_secundario CHAR(255),
     PRIMARY KEY (id)
);

