package com.example.cinemavericks.services;

import com.example.cinemavericks.models.*;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
import com.example.cinemavericks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public Review createReview(PostReviewDTO postReviewDTO){
        Movie targetMovie = movieRepository.findById(postReviewDTO.getMovieId()).get();
        User targetUser = userRepository.findById(postReviewDTO.getUserId()).get();

        Review newReview = new Review(targetUser,targetMovie, postReviewDTO.getTitle(), postReviewDTO.getDate(),
                postReviewDTO.getContent(), postReviewDTO.getRating());

        return reviewRepository.save(newReview);
    }

    // Only for purposes of error handling our PATCH endpoint

    public Optional<Review> getReviewById(long id){
        return reviewRepository.findById(id);
    }

    public Review editReview(ReviewDTO reviewDTO, long id){
        Review targetReview = reviewRepository.findById(id).get();
        targetReview.setTitle(reviewDTO.getTitle());
        targetReview.setDate(reviewDTO.getDate());
        targetReview.setContent(reviewDTO.getContent());
        targetReview.setRating(reviewDTO.getRating());

        return reviewRepository.save(targetReview);
    }

    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }
}
