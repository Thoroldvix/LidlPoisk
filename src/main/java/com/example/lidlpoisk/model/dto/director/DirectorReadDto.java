package com.example.lidlpoisk.model.dto.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorReadDto {

    private String firstName;


    private String lastName;


    private LocalDate birthDate;
}
