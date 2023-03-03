--liquibase formatted sql

--changeset thorold:1
INSERT INTO users (email, password, first_name, last_name, role)
VALUES ('admin@gmail.com', 'admin', 'admin', 'admin', 'ADMIN'),
       ('ivan@gmail.com', '123', 'Ivan', 'Ivanov', 'USER'),
       ('petr@gmail.com', '123', 'Petr', 'Petrov', 'USER'),
       ('sveta@gmail.com', '123', 'Sveta', 'Svetikova', 'USER'),
       ('kate@gmail.com', '123', 'Kate', 'Katov', 'USER');


INSERT INTO director(first_name, last_name, birth_date)
VALUES ('Christopher', 'Nolan', '1970-07-30'),
       ('Quentin', 'Tarantino', '1963-03-27'),
       ('Steven', 'Spielberg', '1946-12-18'),
       ('Martin', 'Scorsese', '1942-11-17');



INSERT INTO movie (title, director_id, release_date, country, genre)
VALUES ('Memento', 1, '2000-10-11', 'United States', 'Mystery/Thriller'),

       ('Jackie Brown', 2, '1997-12-25', 'United States', 'Crime/Drama'),

       ('Raiders of the Lost Ark', 3, '1981-06-12', 'United States', 'Action/Adventure'),
       ('The Departed', 4, '2006-10-06', 'United States', 'Crime/Drama');

INSERT INTO actor(first_name, last_name, birth_date)
VALUES ('Guy', 'Pearce', '1967-10-05'),
       ('Carrie-Anne', 'Moss', '1967-08-21'),
       ('Joe', 'Pantoliano', '1951-09-12'),
       ('Samuel', 'L. Jackson', '1948-12-21'),
       ('Robert', 'De Niro', '1943-08-17'),
       ('Brad', 'Pitt', '1963-12-18'),
       ('Harrison', 'Ford', '1942-07-13'),
       ('Sean', 'Connery', '1930-08-25'),
       ('Leonardo', 'DiCaprio', '1974-11-11'),
       ('Matt', 'Damon', '1970-10-08'),
       ('Jack', 'Nicholson', '1937-04-22');

INSERT INTO actor_movie (actor_id, movie_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (6, 3),
       (7, 3),
       (8, 3),
       (9, 4),
       (10, 4),
       (11, 4);

INSERT INTO review(movie_id, user_id, text, rating)
VALUES (1, 2, 'Good movie', 5),
       (1, 3, 'Bad movie', 2),
       (1, 4, 'Mid movie', 3),
       (1, 5, 'Okay movie', 4),
       (2, 2, 'Good movie', 5),
       (2, 3, 'Good movie', 5),
       (2, 4, 'Good movie', 5),
       (2, 5, 'Good movie', 5),
       (3, 2, 'Good movie', 5),
       (3, 3, 'Good movie', 5),
       (3, 4, 'Good movie', 5),
       (3, 5, 'Good movie', 5),
       (4, 2, 'Good movie', 5),
       (4, 3, 'Good movie', 5),
       (4, 4, 'Good movie', 5),
       (4, 5, 'Good movie', 5);

