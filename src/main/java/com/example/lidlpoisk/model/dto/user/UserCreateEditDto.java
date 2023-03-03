package com.example.lidlpoisk.model.dto.user;

import com.example.lidlpoisk.model.entities.enums.UserRoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateEditDto {
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

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRoleEnum role;


}
