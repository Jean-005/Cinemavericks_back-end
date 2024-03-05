package com.example.cinemavericks.controllers;

import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.models.ReviewDTO;
import com.example.cinemavericks.repositories.ReviewRepository;
import com.example.cinemavericks.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review newReview = reviewService.createReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
    
    @PatchMapping
    public ResponseEntity<Review> editReview(@RequestBody ReviewDTO reviewDTO){
        Review updatedReview = reviewService.editReview(reviewDTO);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteReview(@PathVariable long id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>(id,HttpStatus.NO_CONTENT);
    }




}
