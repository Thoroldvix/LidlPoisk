package com.example.lidlpoisk.model.dto.movie;

import com.example.lidlpoisk.model.dto.director.DirectorReadDto;
import com.example.lidlpoisk.model.dto.review.ReviewReadDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieReadDto {
   private String title;


   private LocalDate releaseDate;


   private String country;


   private String genre;


   private String poster;


   private DirectorReadDto director;

   private List<ReviewReadDto> reviews;
}
