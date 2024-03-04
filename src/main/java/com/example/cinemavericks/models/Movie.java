package com.example.cinemavericks.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;
    @Column
    private int year;
    @Column
    private Genre genre;
    @Column
    private String director;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    @ManyToMany
    private List<MovieList> movieList;

    public Movie(){}

    public Movie(String title, int year, String director){
        this.title = title;
        this.year = year;
        this.director = director;
        this.reviews = new ArrayList<>();
        this.movieList = new ArrayList<>();
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

    public List<MovieList> getMovieList() {
        return this.movieList;
    }

    public void setMovieList(List<MovieList> movieList) {
        this.movieList = movieList;
    }
}
