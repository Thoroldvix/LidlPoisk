package com.example.lidlpoisk.repository;

import com.example.lidlpoisk.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Long> {
}
