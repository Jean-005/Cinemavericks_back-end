package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.MovieListDTO;
import com.example.cinemavericks.models.User;
import com.example.cinemavericks.repositories.MovieListRepository;
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

    public List<MovieList> getAllMovieList() {
        return movieListRepository.findAll();
    }

    public Optional<MovieList> getMovieListById(Long id) {
        return movieListRepository.findById(id);
    }

    public MovieList addMovieList(MovieListDTO movieListDTO) {
        Optional<User> user = userRepository.findById(movieListDTO.getUserId());
        if(user.isPresent()){
            return movieListRepository.save(new MovieList(user.get(), movieListDTO.getTitle()));
        }else{
            //UserId not valid
            return null;
        }

    }
}
