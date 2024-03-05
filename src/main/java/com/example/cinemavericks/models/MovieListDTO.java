package com.example.cinemavericks.models;

public class MovieListDTO {
    private String title;
    private Long userId;

    public MovieListDTO(String title, Long userId) {
        this.title = title;
        this.userId = userId;
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
}
