package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"reviews"})
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"reviews"})
    private User user;

    public Review(String title, String date, String content, double rating){
        this.title = title;
        this.date = date;
        this.content = content;
        this.rating = rating;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
