package com.example.cinemavericks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private GenreEnum genreEnum;

    @JsonIgnoreProperties({"genres"})
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    public Genre(GenreEnum genreEnum){
        this.genreEnum = genreEnum;
    }

    public Genre(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GenreEnum getGenreEnum() {
        return genreEnum;
    }

    public void setGenreEnum(GenreEnum genreEnum) {
        this.genreEnum = genreEnum;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
