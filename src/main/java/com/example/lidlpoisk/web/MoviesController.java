package com.example.lidlpoisk.web;

import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import com.example.lidlpoisk.model.dto.movie.MovieReadDto;
import com.example.lidlpoisk.model.dto.review.ReviewCreateEditDto;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    private final MovieServiceImpl movieService;

    @Autowired
    public MoviesController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieReadDto>> getMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieReadDto> getMovieDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.findById(id));
    }
    @PutMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody @Valid MovieCreateEditDto movieCreateEditDto) {
        movieService.create(movieCreateEditDto);
        return ResponseEntity.created(URI.create("/api/v1/movies")).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
