package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.MovieListDTO;
import com.example.cinemavericks.services.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movielists")
public class MovieListController {
    @Autowired
    MovieListService movieListService;

    //Display all movie list
    @GetMapping
    public ResponseEntity<List<MovieList>> getAllMovieList(){
        return new ResponseEntity<>(movieListService.getAllMovieList(), HttpStatus.OK);
    }

    //Display specific movieList by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieList> getMovieListById(@PathVariable Long id){
        Optional<MovieList> movieList = movieListService.getMovieListById(id);
        if(movieList.isPresent()){
            return new ResponseEntity<>(movieList.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    Creating movieList
    @PostMapping
    public ResponseEntity<MovieList> addMovieList(@RequestBody MovieListDTO movieListDTO){
        MovieList movieList = movieListService.addMovieList(movieListDTO);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }

//    Updating specific fields of the movieList (eg: adding or removing the movies)
    @PatchMapping(value = "/{id}/addMovies")
    public ResponseEntity<MovieList> updatingMovieList(@PathVariable Long id, @RequestBody MovieListDTO movieListDTO){
        MovieList movieList = movieListService.updatingMovieList(id, movieListDTO);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/removeMovies")
    public ResponseEntity<MovieList> removeMovieInMovieList(@PathVariable Long id, @RequestBody MovieListDTO movieListDTO){
        MovieList movieList = movieListService.removeMovieInMovieList(id, movieListDTO);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }


//    Deleting a movieList
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeMovieList(@PathVariable Long id){
        movieListService.removeMovieList(id);
        return new ResponseEntity<>("MovieList Deleted",HttpStatus.OK);
    }
}
