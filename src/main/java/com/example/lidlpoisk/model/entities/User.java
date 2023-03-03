package com.example.lidlpoisk.model.entities;

import com.example.lidlpoisk.model.entities.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    private String password;

    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 128, message = "Name must be between 2 and 128 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews;
}
