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
        if (movieList.isPresent()) {
            for (Long movieId : movieListDTO.getMovieIds()) {
                Movie movie = movieRepository.findById(movieId).get();
                movieList.get().addMovie(movie);
            }
            //save movieList
            return movieListRepository.save(movieList.get());
        }
        //movieList id is not valid
        return null;
    }

//    public MovieList removeMovieInMovieList(Long id, MovieListDTO movieListDTO) {
//        //find MovieList
//        Optional<MovieList> movieList = movieListRepository.findById(id);
//        if (movieList.isPresent()) {
//            for (Long movieId : movieListDTO.getMovieIds()) {
//                for (Movie movie : movieList.get().getMovies()) {
//                    if (movieId == movie.getId()) {
//                        movieList.get().removeMovie(movie);
//                    }
//                }
//            }
//            //save movieList
//            return movieListRepository.save(movieList.get());
//        }
//        //movieList id is not valid
//        return null;
//    }
//
//    // public List<Movie> updateMovieList(MovieListDTO movieListDTO, long id){
//
//    for(long id, movieListDTO.getMovieIds)

    public void removeMovieList(Long id) {
        movieListRepository.deleteById(id);
    };

}
