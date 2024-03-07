package com.example.cinemavericks.models;

import java.util.List;

public class MovieDTO {

    private String title;
    private int year;
    private List<Long> genreIds;
    private String director;
    private int duration;

    public MovieDTO(String title, int year, List<Long> genreIds, String director, int duration) {
        this.title = title;
        this.year = year;
        this.genreIds = genreIds;
        this.director = director;
        this.duration = duration;
    }

    public MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
