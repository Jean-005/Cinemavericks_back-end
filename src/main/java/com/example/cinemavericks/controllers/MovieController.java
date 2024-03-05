package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movies")
public class
MovieController {

    @Autowired
    MovieService movieService;

    //Display all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    //Display movie by id


    //Add new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    //Edit details of a movie
    @PatchMapping(value = "/{movieId}")
    public ResponseEntity<Movie> editMovie(@PathVariable long movieId, @RequestBody Movie newMovie){
        newMovie.setId(movieId);
        movieService.saveMovie(newMovie);
        return new ResponseEntity<>(newMovie, HttpStatus.OK);
    }

    //Show all reviews for a specific movie
    @GetMapping(value = "/{movieId}/reviews")
    public ResponseEntity<List<Review>> seeReviewsOfMovie(@PathVariable long movieId){
        List<Review> reviews = movieService.getReviews(movieId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }

    //Ex:Show all movie lists that contain a movie
    @GetMapping(value = "/{movieId}/movieLists")
    public ResponseEntity<List<MovieList>> seeMovieListsContainingMovie(@PathVariable long movieId){
        List<MovieList> movieLists = movieService.getAllMovieLists(movieId);
        return new ResponseEntity<>(movieLists, HttpStatus.OK);
    }
    //Ex: Filter movies by rating


}
