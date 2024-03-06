package com.example.cinemavericks.models;

import java.util.ArrayList;
import java.util.List;

public class MovieListDTO {
    private String title;
    private boolean isPublic;
    private Long userId;
    private List<Long> movieIds;

    public MovieListDTO(String title, boolean isPublic, Long userId) {
        this.title = title;
        this.isPublic = isPublic;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
