package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long movieId){
        return movieRepository.findById(movieId);
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<Review> getReviews(long movieId){
        return reviewRepository.findByMovieId(movieId);
    }
}
