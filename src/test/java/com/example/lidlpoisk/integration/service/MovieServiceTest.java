package com.example.lidlpoisk.integration.service;

import com.example.lidlpoisk.integration.IntegrationTestBase;
import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.model.entities.Director;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
class MovieServiceTest extends IntegrationTestBase {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MovieServiceImpl movieService;





    @Test
    void findUserById_shouldWork() {
        Director director = new Director(1, "Christopher", "Nolan",LocalDate.of(1970, 7,30));
        Movie movie = new Movie(1, "Memento",
                LocalDate.of(2000, 10, 11),
                "United States", "Mystery/Thriller", "default.jpg", director);

        MovieReadDto actualResult = modelMapper.map(movie, MovieReadDto.class);


        Optional<MovieReadDto> maybeMovie = movieService.findById(1);
        assertTrue(maybeMovie.isPresent());
        Assertions.assertThat(maybeMovie.get()).isEqualTo(actualResult);

    }

    @Test
    void findAll_shouldWork(){ //проверка на наличие всех фильмов
        var movies = movieService.findAll();
        Assertions.assertThat(movies).hasSize(4);

    }
}