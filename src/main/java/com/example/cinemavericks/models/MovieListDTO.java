package com.example.cinemavericks.models;

import java.util.ArrayList;
import java.util.List;

public class MovieListDTO {
    private String title;
    private Long userId;
    private List<Long> movieIds;

    public MovieListDTO(String title, Long userId) {
        this.title = title;
        this.userId = userId;
        this.movieIds = new ArrayList<>();
    }

    public MovieListDTO() {
    }

    //Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(List<Long> movieIds) {
        this.movieIds = movieIds;
    }
}
