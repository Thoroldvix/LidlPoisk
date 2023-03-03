package com.example.lidlpoisk.model.dto.review;

import com.example.lidlpoisk.model.dto.movie.MovieCreateEditDto;
import com.example.lidlpoisk.model.dto.user.UserCreateEditDto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateEditDto {
    @NotBlank(message = "Text should not be empty")
    private String text;

    @Range(min = 1, max = 10, message = "Rating must be between 1 and 10")
    private Integer rating;

    @NotNull(message = "User is mandatory")
    private Integer userId;


}
