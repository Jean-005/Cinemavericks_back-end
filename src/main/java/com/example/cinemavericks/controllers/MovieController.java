package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@RequestParam long movieId){
        Optional<Movie> movie = movieService.getMovieById(movieId).get();
    }


    //Add new movie


    //Edit details of a movie


    //Show all reviews for a specific movie


    //Ex:Show all movie lists that contain a movie

    //Ex: Filter movies by rating


}
