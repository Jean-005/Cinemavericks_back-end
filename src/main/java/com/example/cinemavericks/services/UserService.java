package com.example.cinemavericks.services;

import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.models.User;
import com.example.cinemavericks.models.UserDTO;
import com.example.cinemavericks.repositories.MovieListRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
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

    @Autowired
    ReviewRepository reviewRepository;

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

    public List<Review> getAllReviewsOfUser(long id){
        User targetUser = userRepository.findById(id).get();
        return targetUser.getReviews();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User editUser(long id, UserDTO userDTO){
        User targetUser = userRepository.findById(id).get();
    }

    public void deleteUser(long id){
        User targetUser = userRepository.findById(id).get();
        for(Review review : targetUser.getReviews()) {
            review.setUser(null);
            reviewRepository.save(review);
        }

        for(MovieList movieList : targetUser.getMovieLists()) {
            movieListRepository.delete(movieList);
        }

        userRepository.deleteById(id);
    }
}
