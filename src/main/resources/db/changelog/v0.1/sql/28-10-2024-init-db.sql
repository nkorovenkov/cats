-- liquibase formatted sql
-- changeset nkorovenkov:28-10-2024-init-db

CREATE TABLE cats
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    age    INTEGER      NOT NULL,
    mass INTEGER      NOT NULL
);

INSERT INTO cats (id, age, name, mass)
VALUES (1, 5, 'Pushok', 15),
       (2, 10, 'Barsik', 10),
       (7, 1, 'Stepa', 5),
       (3, 2, 'Falka', 5),
       (15, 12, 'Thomas', 6),
       (8, 2, 'Fluffy', 4);

