package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "movie_lists")
public class MovieList {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonIgnoreProperties("movie_lists")
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    String title;

    @JsonIgnoreProperties("movie_lists")
    @ManyToMany
    @JoinColumn(name = "movie")
    ArrayList<Movie> movies;

    public MovieList(User user, String title){
        this.user = user;
        this.title = title;
        this.movies = new ArrayList<>();

    }

    




}
