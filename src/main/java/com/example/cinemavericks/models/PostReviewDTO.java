package com.example.cinemavericks.models;

public class PostReviewDTO {

    private String title;

    private String date;

    private String content;

    private double rating;

    private long movieId;

    private long userId;

    public PostReviewDTO(){}

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
