package com.example.lidlpoisk.model.dto;

import com.example.lidlpoisk.model.entities.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieUpdateDto {
    String title;


    LocalDate releaseDate;


    String country;


    String genre;


    String poster;


    Director director;
}
