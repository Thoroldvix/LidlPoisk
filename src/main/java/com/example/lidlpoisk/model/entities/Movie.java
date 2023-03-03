package com.example.lidlpoisk.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie")
@Data
@ToString(exclude = {"actors", "reviews"})
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false)
    @NotEmpty(message = "Title is mandatory")
    @Size(min = 2, max = 255, message = "Title must be between 2 and 255 characters")
    private String title;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "country")
    @Size(min = 4, max = 64, message = "Country name must be between 2 and 64 characters")
    private String country;

    @Column(name = "genre")
    private String genre;

    @Column(name = "poster")
    private String poster;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();


    public void addReview(Review review) {
        review.setMovie(this);
        reviews.add(review);
    }
    public void addActor(Actor actor) {
        actor.getMovies().add(this);
        actors.add(actor);
    }
}
