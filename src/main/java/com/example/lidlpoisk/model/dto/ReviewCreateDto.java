package com.example.lidlpoisk.model.dto;

import com.example.lidlpoisk.model.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewCreateDto {
    @NotBlank(message = "Text should not be empty")
    private String text;

    @Size(min = 1, max = 10, message = "Rating must be between 1 and 10")
    private Integer rating;

    @NotNull(message = "User is mandatory")
    private User user;


}
