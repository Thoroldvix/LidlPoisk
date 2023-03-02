package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.model.dto.MovieReadDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<MovieReadDto> findAll();
    public Optional<MovieReadDto> findById(Integer id);
}
