package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.actor.ActorReadDto;
import com.example.lidlpoisk.model.entities.Actor;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.repository.ActorRepository;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.service.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public List<ActorReadDto> findAll() {
        return actorRepository.findAll().stream()
                .map(actor -> modelMapper.map(actor, ActorReadDto.class))
                .toList();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Actor actor = actorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Actor with id: " + id + " doesn't exist"));


        actorRepository.delete(actor);
    }

    @Transactional
    @Override
    public void create(ActorCreateEditDto actorCreateEditDto) {
        Integer movieId = actorCreateEditDto.getMovieId();
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new NotFoundException("Movie with id: " + movieId + " doesn't exist"));

        Actor actor = modelMapper.map(actorCreateEditDto, Actor.class);

        movie.addActor(actor);

        movieRepository.save(movie);
        actorRepository.save(actor);
    }
}


