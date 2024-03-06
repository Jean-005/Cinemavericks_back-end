package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.MovieListDTO;
import com.example.cinemavericks.models.User;
import com.example.cinemavericks.repositories.MovieListRepository;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieListService {
    @Autowired
    MovieListRepository movieListRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<MovieList> getAllMovieList() {
        return movieListRepository.findAll();
    }

    public Optional<MovieList> getMovieListById(Long id) {
        return movieListRepository.findById(id);
    }

    public MovieList addMovieList(MovieListDTO movieListDTO) {
        Optional<User> user = userRepository.findById(movieListDTO.getUserId());
        if (user.isPresent()) {
            return movieListRepository.save(new MovieList(user.get(), movieListDTO.getTitle()));
        } else {
            //UserId not valid
            return null;
        }

    }

    public MovieList updatingMovieList(Long id, MovieListDTO movieListDTO) {
        //find MovieList
        Optional<MovieList> movieList = movieListRepository.findById(id);
        List<Movie> moviesToAdd = new ArrayList<>();

        if (movieList.isPresent()) {
            movieList.get().setTitle(movieListDTO.getTitle());
            movieList.get().setPublic(movieListDTO.isPublic());

            for (Long movieId : movieListDTO.getMovieIds()) {
                Movie movie = movieRepository.findById(movieId).get();
                moviesToAdd.add(movie);
            }

            for (Movie movie : moviesToAdd){
                //CHECK if specified movie is not on the movieList
                if(!movieList.get().getMovies().contains(movie)){
                    movieList.get().addMovie(movie);
                }
            }

            //save movieList
            return movieListRepository.save(movieList.get());
        }
        //movieList id is not valid
        return null;
    }

    public MovieList removeMovieInMovieList(Long id, MovieListDTO movieListDTO) {
        MovieList movieList = movieListRepository.findById(id).get();
        List<Movie> removeList = new ArrayList<>();

        //Add the movie to be deleted IN removeList
        for (Long movieId : movieListDTO.getMovieIds()){
            Movie movie = movieRepository.findById(movieId).get();
            removeList.add(movie);
        }

        //REMOVE movie from movieList using removeList
        for (Movie movie : removeList){
            //CHECK if specified movie is on the movieList
            if(movieList.getMovies().contains(movie)){
                movieList.removeMovie(movie);
            }
        }
        return movieListRepository.save(movieList);
    }

    public void removeMovieList(Long id) {
        movieListRepository.deleteById(id);
    };

}
