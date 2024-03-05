package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "movie_lists")
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties("movie_lists")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @JsonIgnoreProperties("movie_lists")
    @ManyToMany
    @JoinTable(
        name = "movies_movie_lists",
        joinColumns = @JoinColumn(name = "movie_list_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private ArrayList<Movie> movies;

    public MovieList(){}

    public MovieList(User user, String title){
        this.user = user;
        this.title = title;
        this.movies = new ArrayList<>();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    
}
