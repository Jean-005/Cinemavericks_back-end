package com.example.cinemavericks.services;

import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.User;
import com.example.cinemavericks.repositories.MovieListRepository;
import com.example.cinemavericks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieListRepository movieListRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public List<MovieList> getAllListsOfUser(long id){
        User targetUser = userRepository.findById(id).get();
        return targetUser.getMovieLists();
    }
}
