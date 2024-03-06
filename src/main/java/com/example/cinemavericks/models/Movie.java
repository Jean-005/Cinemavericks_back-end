package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;
    @Column
    private int year;
    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column
    private String director;

    @Column
    private int duration;
    @Column(name = "average_rating")
    private double averageRating;

    @JsonIgnoreProperties({"movies"})
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    @JsonIgnoreProperties({"movies"})
    @ManyToMany(mappedBy = "movies")
    private List<MovieList> movieLists;

    public Movie(){}

    public Movie(String title, int year, Genre genre, String director, int duration){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.reviews = new ArrayList<>();
        this.movieLists = new ArrayList<>();
        this.averageRating = 0;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<MovieList> getMovieLists() {
        return this.movieLists;
    }

    public void setMovieLists(List<MovieList> movieLists) {
        this.movieLists = movieLists;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double calculateAverageRating(){
        double ratingsSum = 0;
        for (Review review : this.reviews){
            ratingsSum += review.getRating();
        }
        this.averageRating = ratingsSum / this.reviews.size();
        this.averageRating = Math.round(this.averageRating * 100.0) / 100.0;

        return this.averageRating;
    }


}
