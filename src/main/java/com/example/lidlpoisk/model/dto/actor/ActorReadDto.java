package com.example.lidlpoisk.model.dto.actor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorReadDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthDate;
}
