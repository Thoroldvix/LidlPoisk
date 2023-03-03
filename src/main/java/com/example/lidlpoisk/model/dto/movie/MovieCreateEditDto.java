package com.example.lidlpoisk.model.dto.movie;

import com.example.lidlpoisk.model.dto.director.DirectorCreateEditDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCreateEditDto {


    @NotEmpty(message = "Title is mandatory")
    @Size(min = 2, max = 255, message = "Title must be between 2 and 255 characters")
    private String title;

    private LocalDate releaseDate;


    @Size(min = 4, max = 64, message = "Country name must be between 2 and 64 characters")
    private String country;

    @NotEmpty
    private String genre;


    private String poster;


    private Integer directorId;


}
