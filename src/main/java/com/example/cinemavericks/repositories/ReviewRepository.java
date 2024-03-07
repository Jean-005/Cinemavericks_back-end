package com.example.cinemavericks.repositories;

import com.example.cinemavericks.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovieId(long movieId);

    List<Review> findByUserIdOrderByDateAsc(long userId);

    List<Review> findByUserIdOrderByDateDesc(long userId);

    List<Review> findByMovieIdOrderByDateAsc(long movieId);

    List<Review> findByMovieIdOrderByDateDesc(long movieId);


}
