package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.model.dto.ReviewCreateDto;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.model.entities.Review;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.repository.ReviewRepository;
import com.example.lidlpoisk.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MovieReadDto> findAll() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieReadDto.class))
                .toList();
    }

    @Override
    public void delete(Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie not found"));
        movieRepository.delete(movie);
    }

    @Override
    public Optional<MovieReadDto> findById(Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return Optional.of(modelMapper.map(movie.get(), MovieReadDto.class));
        }
        throw new NotFoundException("Movie not found");
    }

    @Override
    @Transactional
    public void addReview(ReviewCreateDto reviewCreateDto, Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie not found"));
        Review review = modelMapper.map(reviewCreateDto, Review.class);

        movie.addReview(review);

        reviewRepository.save(review);
        movieRepository.save(movie);
    }
}
