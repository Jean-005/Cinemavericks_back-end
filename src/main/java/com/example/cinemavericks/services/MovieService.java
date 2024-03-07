package com.example.cinemavericks.services;

import com.example.cinemavericks.models.Genre;
import com.example.cinemavericks.models.GenreEnum;
import com.example.cinemavericks.models.Movie;
import com.example.cinemavericks.models.MovieList;
import com.example.cinemavericks.models.Review;
import com.example.cinemavericks.repositories.GenreRepository;
import com.example.cinemavericks.repositories.MovieListRepository;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    GenreRepository genreRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long movieId){
        return movieRepository.findById(movieId);
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<Review> getReviews(long movieId){
        return reviewRepository.findByMovieId(movieId);
    }


    public List<MovieList> getAllMovieLists(long movieId) {
        return movieListRepository.findByMoviesId(movieId);
    }

    public List<Movie> filterMovies(double minRating, double maxRating){
        return movieRepository.findByAverageRatingBetween(minRating, maxRating);
    }

    public List<Movie> filterMovies(GenreEnum genre){
        List<Movie> filterResult = new ArrayList<>();
        Genre targetGenre = genreRepository.findByGenreEnum(genre);
        for (Movie movie: movieRepository.findAll()){
            if (movie.getGenres().contains(targetGenre)){
                filterResult.add(movie);
            }
        }
        return filterResult;
    }

    public List<Movie> filterMovies(int minDuration, int maxDuration){
        return movieRepository.findByDurationBetween(minDuration, maxDuration);
    }
}
