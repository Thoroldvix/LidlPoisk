package com.example.lidlpoisk.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "movie")
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    @NotBlank(message = "Text should not be empty")
    private String text;

    @Column(name = "rating")
    @Size(min = 1, max = 10, message = "Rating must be between 1 and 10")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;


}
