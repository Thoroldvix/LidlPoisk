package com.example.lidlpoisk.service;

import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import com.example.lidlpoisk.model.dto.movie.MovieReadDto;
import com.example.lidlpoisk.model.dto.review.ReviewCreateEditDto;
import com.example.lidlpoisk.model.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieReadDto> findAll();

    void delete(Integer id);


    MovieReadDto findById(Integer id);


    Movie create(MovieCreateEditDto movieCreateEditDto);
}
