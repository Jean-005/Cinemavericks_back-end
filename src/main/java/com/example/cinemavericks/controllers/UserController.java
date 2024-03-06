package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.models.User;
import com.example.cinemavericks.models.UserDTO;
import com.example.cinemavericks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/movieLists")
    public ResponseEntity<List<MovieList>> getAllMovieListsByUser(@PathVariable long id){
        Optional<User> targetUser = userService.getUserById(id);
        if(targetUser.isPresent()){
            List<MovieList> allMovieLists = userService.getAllListsOfUser(id);
            return new ResponseEntity<>(allMovieLists, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByUser(@PathVariable long id){
        Optional<User> targetUser = userService.getUserById(id);
        if(targetUser.isPresent()){
            List<Review> allReviews = userService.getAllReviewsOfUser(id);
            return new ResponseEntity<>(allReviews, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        Optional<User> targetUser = userService.getUserById(id);
        if (targetUser.isPresent()) {
            userService.editUser(id, userDTO);
            return new ResponseEntity<>(targetUser.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id){
        Optional<User> targetUser = userService.getUserById(id);
        if(targetUser.isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
