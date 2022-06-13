CREATE TABLE artists (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(255) NOT NULL,
     age int NOT NULL,
     discography CHAR(255),
     PRIMARY KEY (id)
);

CREATE TABLE songs (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(255) NOT NULL,
     duration CHAR(255) NOT NULL,
     rating CHAR(255),
     PRIMARY KEY (id)
);

