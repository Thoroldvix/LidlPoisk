package com.example.lidlpoisk.web;

import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesController {

    private final MovieServiceImpl movieService;

    @GetMapping
    public ResponseEntity<List<MovieReadDto>> getMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieReadDto> getMovieDetails(@PathVariable Integer id) {
        Optional<MovieReadDto> movie = movieService.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
