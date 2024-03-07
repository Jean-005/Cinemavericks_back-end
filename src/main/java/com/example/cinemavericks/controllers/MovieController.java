package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.GenreEnum;
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

    //Display movie by movieId
    @GetMapping(value = "/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long movieId){
        Optional<Movie> movie = movieService.getMovieById(movieId);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Add new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    //Edit details of a movie
    @PatchMapping(value = "/{movieId}")
    public ResponseEntity<Movie> editMovie(@PathVariable long movieId, @RequestBody Movie newMovie){
        if (movieService.getMovieById(movieId).isPresent()) {
            newMovie.setId(movieId);
            movieService.saveMovie(newMovie);
            return new ResponseEntity<>(newMovie, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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
    @GetMapping(value = "/filterByRating")
    public ResponseEntity<List<Movie>> filterMoviesByRating(
            @RequestParam(defaultValue = "0") double minRating,
            @RequestParam(defaultValue = "5") double maxRating
    ){
        List<Movie> filteredMovies = movieService.filterMovies(minRating,maxRating);
        return new ResponseEntity<>(filteredMovies, HttpStatus.OK);
    }

    // Filter movies by genre
    @GetMapping(value = "/filterByGenre")
    public ResponseEntity<List<Movie>> filterMovieByGenre(@RequestParam GenreEnum genre){
        List<Movie> filteredMovies = movieService.filterMovies(genre);
        return new ResponseEntity<>(filteredMovies, HttpStatus.OK);
    }

    // Filter movies by duration
    @GetMapping(value = "/filterByDuration")
    public ResponseEntity<List<Movie>> filterMovieByDuration(
            @RequestParam(defaultValue = "0") int minDuration,
            @RequestParam(defaultValue = "500") int maxDuration
    ){
        List<Movie> filteredMovies = movieService.filterMovies(minDuration, maxDuration);
        return new ResponseEntity<>(filteredMovies, HttpStatus.OK);
    }

    // Sort Reviews by time(newest/oldest); Method is extensible for other categories as well
    @GetMapping(value = "/{movieId}/reviews/sort{timeOrder}")
    public ResponseEntity<List<Review>> sortReviews(
            @PathVariable String timeOrder,
            @PathVariable long movieId){
        // sort by time if value has been inputted
        if(timeOrder.equals("newest")|| timeOrder.equals("oldest")){
            List<Review> reviews = movieService.sortByTime(timeOrder, movieId);
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
