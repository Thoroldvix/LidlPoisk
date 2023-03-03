package com.example.lidlpoisk.web;

import com.example.lidlpoisk.model.dto.MovieReadDto;
import com.example.lidlpoisk.model.dto.ReviewCreateDto;
import com.example.lidlpoisk.service.impl.MovieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
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
        Optional<MovieReadDto> movie = movieService.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/addReview")
    public ResponseEntity<?> addReview(@RequestBody @Valid ReviewCreateDto reviewCreateDto, @PathVariable Integer id) {
        movieService.addReview(reviewCreateDto, id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
