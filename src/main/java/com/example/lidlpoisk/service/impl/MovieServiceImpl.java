package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import com.example.lidlpoisk.model.dto.movie.MovieReadDto;
import com.example.lidlpoisk.model.entities.Director;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.repository.ActorRepository;
import com.example.lidlpoisk.repository.DirectorRepository;
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
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ReviewRepository reviewRepository, ModelMapper modelMapper, ActorRepository actorRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
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
                .orElseThrow(() -> new NotFoundException("Movie with id: " + id +  " doesn't exist"));
        movieRepository.delete(movie);
    }

    @Override
    public MovieReadDto findById(Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie with id: " + id + " doesn't exist"));
        return modelMapper.map(movie, MovieReadDto.class);

    }



    @Override
    public Movie create(MovieCreateEditDto movieCreateEditDto) {
        Director director = directorRepository.findById(movieCreateEditDto.getDirectorId())
                .orElseThrow(() -> new NotFoundException("Director not found"));

        Movie movie = modelMapper.map(movieCreateEditDto, Movie.class);
        movie.setDirector(director);

      return movieRepository.save(movie);
    }
}
