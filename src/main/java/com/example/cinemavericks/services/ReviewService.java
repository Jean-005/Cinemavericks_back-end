package com.example.cinemavericks.services;

import com.example.cinemavericks.models.*;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
import com.example.cinemavericks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public double calculateAverageRating(long id){
        Movie targetMovie = movieRepository.findById(id).get();
        targetMovie.calculateAverageRating();
        movieRepository.save(targetMovie);
        return targetMovie.getAverageRating();
    }

    public Review createReview(PostReviewDTO postReviewDTO){
        Movie targetMovie = movieRepository.findById(postReviewDTO.getMovieId()).get();
        User targetUser = userRepository.findById(postReviewDTO.getUserId()).get();

        Review newReview = new Review(targetUser,targetMovie, postReviewDTO.getTitle(),
                postReviewDTO.getContent(), postReviewDTO.getRating());

        //updates the average rating of the movie
        reviewRepository.save(newReview);
        calculateAverageRating(postReviewDTO.getMovieId());

        return newReview;
    }

    // Only for purposes of error handling our PATCH endpoint
    public Optional<Review> getReviewById(long id){
        return reviewRepository.findById(id);
    }

    public Review editReview(ReviewDTO reviewDTO, long id){
        Review targetReview = reviewRepository.findById(id).get();
        targetReview.setTitle(reviewDTO.getTitle());
        targetReview.setDate(LocalDateTime.now());
        targetReview.setContent(reviewDTO.getContent());
        targetReview.setRating(reviewDTO.getRating());

        //updates the average rating of the movie
        reviewRepository.save(targetReview);
        calculateAverageRating(id);

        return targetReview;
    }

    public void deleteReview(long id){

        reviewRepository.deleteById(id);
        //updates the average rating of the movie
        calculateAverageRating(id);
    }


    public List<Review> sortByTime(String timeOrder) {
        if (timeOrder == "newest"){
            return reviewRepository.
        }
        if (timeOrder == "oldest"){

        }
    }
}
