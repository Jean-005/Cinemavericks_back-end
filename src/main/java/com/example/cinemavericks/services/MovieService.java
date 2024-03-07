package com.example.cinemavericks.services;

import com.example.cinemavericks.models.*;
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

    public Movie saveMovie(MovieDTO movieDTO){
        List<Genre> targetGenres = new ArrayList<>();
        for (Long genreId: movieDTO.getGenreIds()){
            Optional<Genre> genre = genreRepository.findById(genreId);
            if (genre.isPresent()){
                targetGenres.add(genre.get());
            }
        }

        Movie movie = new Movie(movieDTO.getTitle(), movieDTO.getYear(), targetGenres,
                movieDTO.getDirector(), movieDTO.getDuration());
        return movieRepository.save(movie);
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
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

    //Get sorted reviews
    public List<Review> sortByTime(String timeOrder, long movieId) {
        if (timeOrder.equals("newest")){
            return reviewRepository.findByMovieIdOrderByDateDesc(movieId);
        }
        if (timeOrder.equals("oldest")){
            return reviewRepository.findByMovieIdOrderByDateAsc(movieId);
        }
        return null;
    }

    public Movie editMovie(long movieId, MovieDTO newMovieDTO) {
        Movie movieToEdit = movieRepository.findById(movieId).get();

        //Genres
        List<Genre> targetGenres = new ArrayList<>();
        for (Long genreId: newMovieDTO.getGenreIds()){
            Optional<Genre> genre = genreRepository.findById(genreId);
            if (genre.isPresent()){
                targetGenres.add(genre.get());
            }
        }

        movieToEdit.setTitle(newMovieDTO.getTitle());
        movieToEdit.setYear(newMovieDTO.getYear());
        movieToEdit.setDirector(newMovieDTO.getDirector());
        movieToEdit.setGenres(targetGenres);
        movieToEdit.setDuration(newMovieDTO.getDuration());

        return movieRepository.save(movieToEdit);
    }
}
