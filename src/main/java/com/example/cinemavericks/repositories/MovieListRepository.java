package com.example.cinemavericks.repositories;

import com.example.cinemavericks.models.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}
