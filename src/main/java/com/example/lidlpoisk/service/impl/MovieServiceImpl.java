package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<MovieReadDto> findAll() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieReadDto.class))
                .toList();
    }
    @Override
    public Optional<MovieReadDto> findById(Integer id) {
        return movieRepository.findById(id).map(value -> modelMapper.map(value, MovieReadDto.class));

    }
}
