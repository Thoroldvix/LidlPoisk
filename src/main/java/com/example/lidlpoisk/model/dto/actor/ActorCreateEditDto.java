package com.example.lidlpoisk.model.dto.actor;

import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorCreateEditDto {
        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
        private String firstName;

        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
        private String lastName;

        private LocalDate birthDate;

        private Integer movieId;

}

