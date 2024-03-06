package com.example.cinemavericks.repositories;

import com.example.cinemavericks.models.Genre;
import com.example.cinemavericks.models.GenreEnum;
import com.example.cinemavericks.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByAverageRatingBetween(double rangeStart, double rangeEnd);

    List<Movie> findByGenre(GenreEnum genre);
    List<Movie> findByDurationBetween(int minDuration, int maxDuration);
}
