--liquibase formatted sql

--changeset thorold:1
CREATE TABLE director
(
    id         INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name       VARCHAR(128) NOT NULL,
    birth_date DATE         NOT NULL
);

--changeset thorold:2
CREATE TABLE movie
(
    id           INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title        VARCHAR(255) NOT NULL,
    director_id  INT REFERENCES director (id),
    release_date DATE         NOT NULL,
    country      VARCHAR(64),
    genre        VARCHAR(64),
    poster       VARCHAR(64) DEFAULT 'default.jpg'
);
--changeset thorold:3
CREATE TABLE actor
(
    id         INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name       VARCHAR(128) NOT NULL,
    birth_date DATE         NOT NULL,
    movie_id   INT REFERENCES movie (id)
);
--changeset thorold:4
CREATE TABLE users
(
    id         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(64) NOT NULL,
    last_name  VARCHAR(64) NOT NULL,
    password   VARCHAR(64) NOT NULL,
    email      VARCHAR(64) NOT NULL,
    role       VARCHAR(32) NOT NULL
);
--changeset thorold:5
CREATE TABLE review
(
    id       BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    movie_id INT REFERENCES movie (id),
    user_id  BIGINT REFERENCES users (id),
    text     VARCHAR(255) NOT NULL,
    rating   INT          NOT NULL
);

