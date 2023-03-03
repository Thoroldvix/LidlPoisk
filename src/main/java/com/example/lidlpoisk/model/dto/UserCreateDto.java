package com.example.lidlpoisk.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateDto {

    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    private String lastName;
}
