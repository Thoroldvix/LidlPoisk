package com.example.lidlpoisk.service;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import com.example.lidlpoisk.model.dto.review.ReviewCreateEditDto;
import com.example.lidlpoisk.model.entities.Director;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.model.entities.Review;
import com.example.lidlpoisk.repository.DirectorRepository;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.repository.ReviewRepository;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private DirectorRepository directorRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MovieServiceImpl movieService;


    private final Integer MOVIE_ID = 1;

    private final Integer DIRECTOR_ID = 1;





    @Test void deleteMovieById_Should_Work() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID);

        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.of(movie));

        movieService.delete(MOVIE_ID);

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
        verify(movieRepository, Mockito.times(1)).delete(movie);
    }


    @Test
    void deleteMovieById_Throws_NotFound() {
        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> movieService.delete(MOVIE_ID));

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
    }

    @Test
    void findMovieById_Throws_NotFound() {
        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> movieService.findById(MOVIE_ID));

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);

    }

    @Test
    void findMovieById_Should_Work() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID);

        when(movieRepository.findById(1)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieRepository.findById(MOVIE_ID);

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
        assertTrue(result.isPresent());
        assertEquals(result.get(), movie);

    }

    @Test
    void findAll_Should_Work() {
        when(movieRepository.findAll()).thenReturn(List.of(new Movie()));
        var movies = movieService.findAll();
        assertThat(movies).hasSize(1);
    }
    @Test
    void create_Should_Work() {
        Movie movie = new Movie();
        MovieCreateEditDto movieCreateEditDto = new MovieCreateEditDto();
        movieCreateEditDto.setDirectorId(DIRECTOR_ID);

        Director director = new Director();
        director.setId(DIRECTOR_ID);

        when(directorRepository.findById(1)).thenReturn(Optional.of(director));
        when(modelMapper.map(movieCreateEditDto, Movie.class)).thenReturn(movie);
        when(movieRepository.save(movie)).thenReturn(movie);

        var result = movieService.create(movieCreateEditDto);


        verify(directorRepository, Mockito.times(1)).findById(1);
        verify(modelMapper, Mockito.times(1)).map(movieCreateEditDto, Movie.class);
        verify(movieRepository, Mockito.times(1)).save(movie);
        assertEquals(result, movie);
    }
    @Test
    void create_Throws_NotFound() {
        MovieCreateEditDto movieCreateEditDto = new MovieCreateEditDto();
        movieCreateEditDto.setDirectorId(DIRECTOR_ID);

        when(directorRepository.findById(DIRECTOR_ID)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> movieService.create(movieCreateEditDto));

        verify(directorRepository, Mockito.times(1)).findById(1);
    }


}

