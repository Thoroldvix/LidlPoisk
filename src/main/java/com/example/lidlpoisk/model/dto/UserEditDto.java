package com.example.lidlpoisk.model.dto;

import com.example.lidlpoisk.model.entities.PersonalInfo;
import com.example.lidlpoisk.model.entities.enums.UserRoleEnum;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.Data;
@Data
public class UserEditDto {

    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @Embedded
    private PersonalInfo personalInfo;


    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;


}
