package com.example.cinemavericks.repositories;

import com.example.cinemavericks.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
