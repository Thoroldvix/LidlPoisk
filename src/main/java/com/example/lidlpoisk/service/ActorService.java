package com.example.lidlpoisk.service;


import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.actor.ActorReadDto;
import com.example.lidlpoisk.model.entities.Actor;

import java.util.List;

public interface ActorService {

    void delete(Integer id);

    void create (ActorCreateEditDto actorCreateEditDto);

    List<ActorReadDto> findAll();
}
