package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_lists")
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties({"movieLists","reviews"})
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @JsonIgnoreProperties({"movieLists","reviews"})
    @ManyToMany
    @JoinTable(
        name = "movies_movie_lists",
        joinColumns = @JoinColumn(name = "movie_list_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie){
        this.movies.remove(movie);
    }
    
}
