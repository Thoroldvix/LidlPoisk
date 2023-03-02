package com.example.lidlpoisk.model.dto;

import com.example.lidlpoisk.model.entities.Director;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieReadDto {
    String title;


    LocalDate releaseDate;


    String country;


    String genre;


    String poster;


    Director director;
}
