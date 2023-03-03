package com.example.lidlpoisk.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    private String lastName;
}
