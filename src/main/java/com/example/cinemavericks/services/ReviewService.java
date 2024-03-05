package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.models.ReviewDTO;
import com.example.cinemavericks.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public Review editReview(ReviewDTO reviewDTO){
        Review targetReview = reviewRepository.findById(reviewDTO.getId()).get();
        targetReview.setTitle(reviewDTO.getTitle());
        targetReview.setDate(reviewDTO.getDate());
        targetReview.setContent(reviewDTO.getContent());
        targetReview.setRating(reviewDTO.getRating());

        return reviewRepository.save(targetReview);
    }
}
