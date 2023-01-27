DROP TABLE IF EXISTS authentication;

CREATE TABLE authentication (
                       id int AUTO_INCREMENT primary key,
                       username varchar(255),
                       password varchar(255)
);


INSERT INTO authentication (username, password) VALUES ("YvesLaRock", "123456789");
INSERT INTO authentication (username, password) VALUES ("BertilJonsson", "123456789");
INSERT INTO authentication (username, password) VALUES ("GertrudeLarsson", "123456789");
INSERT INTO authentication (username, password) VALUES ("ToddBengtsson", "123465789");