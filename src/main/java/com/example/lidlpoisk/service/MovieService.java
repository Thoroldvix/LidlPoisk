package com.example.lidlpoisk.service;

import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.model.dto.ReviewCreateDto;
import com.example.lidlpoisk.model.entities.Review;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieReadDto> findAll();

    void delete(Integer id);


    Optional<MovieReadDto> findById(Integer id);

    void addReview(ReviewCreateDto reviewCreateDto, Integer id);
}
