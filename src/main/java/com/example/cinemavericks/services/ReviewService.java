package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Review;
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
}
