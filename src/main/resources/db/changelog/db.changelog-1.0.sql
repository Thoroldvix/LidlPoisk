--liquibase formatted sql

--changeset thorold:1
CREATE TABLE director
(
    id         INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
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
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    birth_date DATE         NOT NULL
);
--changeset thorold:4
CREATE TABLE actor_movie (
                             actor_id int NOT NULL ,
                             movie_id int NOT NULL ,
                             PRIMARY KEY (actor_id, movie_id),
                             FOREIGN KEY (actor_id) REFERENCES actor (id),
                             FOREIGN KEY (movie_id) REFERENCES movie (id)
)
--changeset thorold:5
CREATE TABLE users
(
    id         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(64) NOT NULL,
    last_name  VARCHAR(64) NOT NULL,
    password   VARCHAR(64) NOT NULL,
    email      VARCHAR(64) NOT NULL,
    role       VARCHAR(32) NOT NULL
);
--changeset thorold:6
CREATE TABLE review
(
    id       BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    movie_id INT REFERENCES movie (id) ON DELETE CASCADE,
    user_id  BIGINT REFERENCES users (id) ON DELETE CASCADE,
    text     VARCHAR(255) NOT NULL,
    rating   INT          NOT NULL
);

