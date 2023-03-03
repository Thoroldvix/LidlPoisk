package com.example.lidlpoisk.model.dto.director;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorCreateEditDto{
        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
       private  String firstName;
        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
        private String lastName;

        private LocalDate birthDate;

}
