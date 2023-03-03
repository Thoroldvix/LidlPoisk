package com.example.lidlpoisk.web;

import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.actor.ActorReadDto;
import com.example.lidlpoisk.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
public class ActorsController {

    private final ActorService actorService;

    @Autowired
    public ActorsController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping
    public ResponseEntity<List<ActorReadDto>> getActors() {
        return ResponseEntity.ok(actorService.findAll());
    }
    @PutMapping
    @Operation(summary = "Add new actor")
    public ResponseEntity<?> addActor(@RequestBody @Valid ActorCreateEditDto actor) {

        actorService.create(actor);
        return ResponseEntity.accepted().build();
    }
}
