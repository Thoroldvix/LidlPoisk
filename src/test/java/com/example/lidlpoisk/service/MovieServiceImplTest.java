package com.example.lidlpoisk.service;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.ReviewCreateDto;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.model.entities.Review;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.repository.ReviewRepository;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MovieServiceImpl movieService;


    private final Integer MOVIE_ID = 1;

    @Test
    void deleteMovieById_Successful() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID);

        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.of(movie));

        movieService.delete(MOVIE_ID);

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
        verify(movieRepository, Mockito.times(1)).delete(movie);
    }


    @Test
    void deleteMovieById_MovieNotFound() {
        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> movieService.delete(MOVIE_ID));

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
    }

    @Test
    void findMovieById_MovieNotFound() {
        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> movieService.findById(MOVIE_ID));

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);

    }

    @Test
    void findMovieById_Successful() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID);

        when(movieRepository.findById(1)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieRepository.findById(MOVIE_ID);

        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
        assertTrue(result.isPresent());
        assertEquals(result.get(), movie);

    }

    @Test
    void findAll_Successful() {
        when(movieRepository.findAll()).thenReturn(List.of(new Movie()));
        var movies = movieService.findAll();
        assertThat(movies).hasSize(1);
    }

    @Test
    public void addReview_Successful() {

        Movie movie = new Movie();
        movie.setId(MOVIE_ID);
        ReviewCreateDto reviewCreateDto = new ReviewCreateDto();
        Review review = new Review();

        when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.of(movie));
        when(modelMapper.map(reviewCreateDto, Review.class)).thenReturn(review);


        movieService.addReview(reviewCreateDto, MOVIE_ID);


        verify(movieRepository, Mockito.times(1)).findById(MOVIE_ID);
        verify(reviewRepository, Mockito.times(1)).save(review);
        verify(movieRepository, Mockito.times(1)).save(movie);
        assertEquals(1, movie.getReviews().size());
        assertEquals(review, movie.getReviews().get(0));
    }

    @Test
    public void addReview_MovieNotFound() {

        ReviewCreateDto reviewCreateDto = new ReviewCreateDto();

        Mockito.when(movieRepository.findById(MOVIE_ID)).thenReturn(Optional.empty());


        assertThrows(NotFoundException.class, () -> {
            movieService.addReview(reviewCreateDto, MOVIE_ID);
        });
        verify(reviewRepository, Mockito.times(0)).save(Mockito.any());
        verify(movieRepository, Mockito.times(0)).save(Mockito.any());
    }
}

