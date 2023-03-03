package com.example.lidlpoisk.model.dto;

import com.example.lidlpoisk.model.entities.Director;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieReadDto {
    String title;


    LocalDate releaseDate;


    String country;


    String genre;


    String poster;


    Director director;

    List<ReviewReadDto> reviews;
}
