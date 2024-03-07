package com.example.cinemavericks.components;

import com.example.cinemavericks.models.*;
import com.example.cinemavericks.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GenreRepository genreRepository;

    public DataLoader(){

    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Zarrin");
        User user2 = new User("Gabriel");
        User user3 = new User("Leila");
        User user4 = new User("Monesha");
        User user5 = new User("Not Zarrin");
        User user6 = new User("Tommy");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);

        Genre action = new Genre(GenreEnum.ACTION);
        Genre adventure = new Genre(GenreEnum.ADVENTURE);
        Genre anime = new Genre(GenreEnum.ANIME);
        Genre comedy = new Genre(GenreEnum.COMEDY);
        Genre fantasy = new Genre(GenreEnum.FANTASY);
        Genre historical = new Genre(GenreEnum.HISTORICAL);
        Genre horror = new Genre(GenreEnum.HORROR);
        Genre romance = new Genre(GenreEnum.ROMANCE);
        Genre scifi = new Genre(GenreEnum.SCIFI);
        Genre thriller = new Genre(GenreEnum.THRILLER);


        genreRepository.save(action);
        genreRepository.save(adventure);
        genreRepository.save(anime);
        genreRepository.save(comedy);
        genreRepository.save(fantasy);
        genreRepository.save(historical);
        genreRepository.save(horror);
        genreRepository.save(romance);
        genreRepository.save(scifi);
        genreRepository.save(thriller);

        List<Genre> genres1 = new ArrayList<>();
        List<Genre> genres2 = new ArrayList<>();
        List<Genre> genres3 = new ArrayList<>();
        List<Genre> genres4 = new ArrayList<>();

        genres1.add(comedy);
        genres1.add(adventure);
        genres2.add(thriller);
        genres2.add(action);
        genres3.add(romance);
        genres4.add(scifi);

        Movie hoodWinked = new Movie("Hoodwinked", 2005 ,"Cory Edwards", 80, genres1);
        Movie whipLash = new Movie("Whiplash", 2014, "Damien Chazelle",  107, genres2);
        Movie thisIsMeNow = new Movie("This is Me Now", 2024,"Dave Mayers",  65, genres1);
        Movie scottPilgrimVsTheWorld = new Movie("Scott Pilgrim Vs The World", 2010,"Edgar Wright",  112, genres2);

        Movie movie1 = new Movie("The Shawshank Redemption", 1994,"Frank Darabont",  142, genres2);
        Movie movie2 = new Movie("The Godfather", 1972,"Francis Ford Coppola", 175, genres2);
        Movie movie3 = new Movie("The Dark Knight", 2008,"Christopher Nolan", 152, genres2);
        Movie movie4 = new Movie("Schindler's List", 1993,"Steven Spielberg", 195, genres2);
        Movie movie5 = new Movie("Pulp Fiction", 1994,"Quentin Tarantino", 165, genres2);
        Movie movie6 = new Movie("The Lord of the Rings: The Return of the King", 2003,"Peter Jackson", 210, genres1);
        Movie movie7 = new Movie("Fight Club", 1999,"David Fincher",  139, genres2);
        Movie movie8 = new Movie("Forrest Gump", 1994,"Robert Zemeckis", 142, genres1);
        Movie movie9 = new Movie("Inception", 2010,"Christopher Nolan", 148, genres1);
        Movie movie10 = new Movie("The Matrix", 1999,"Wachowskis",  136, genres2);

        movieRepository.save(hoodWinked);
        movieRepository.save(whipLash);
        movieRepository.save(thisIsMeNow);
        movieRepository.save(scottPilgrimVsTheWorld);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
        movieRepository.save(movie6);
        movieRepository.save(movie7);
        movieRepository.save(movie8);
        movieRepository.save(movie9);
        movieRepository.save(movie10);

        Review review1 = new Review(user3, scottPilgrimVsTheWorld, "wow so cool","FILM SO GOOD WOW WOOOOOOO!", 5);
        Review review2 = new Review(user5, movie2, "Not Great","Hmmm, it was okay. Not the best but not bad.", 2.5);
        Review review3 = new Review(user6, movie2, "Don't even","Don't.", 1);


        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);

        // Making movie object equal to its database counterpart that has a review attached to it
        movie2 = movieRepository.findById(6L).get();

        movie2.calculateAverageRating();
        movieRepository.save(movie2);

        scottPilgrimVsTheWorld = movieRepository.findById(4L).get();
        scottPilgrimVsTheWorld.calculateAverageRating();
        movieRepository.save(scottPilgrimVsTheWorld);


        MovieList movieList1 = new MovieList(user1,"Fav List");
        MovieList movieList2 = new MovieList(user2,"Worst List");
        MovieList movieList3 = new MovieList(user3,"Cry List");
        MovieList movieList4 = new MovieList(user4,"Sad List");
        MovieList movieList5 = new MovieList(user5,"Horror List");
        MovieList movieList6 = new MovieList(user6,"Watch List");
        MovieList movieList7 = new MovieList(user2, "Best List");

        movieList1.addMovie(scottPilgrimVsTheWorld);
        movieList1.addMovie(whipLash);
        movieList1.addMovie(thisIsMeNow);
        movieList1.addMovie(hoodWinked);

        movieList7.addMovie(hoodWinked);
        movieList7.addMovie(whipLash);
        movieList7.addMovie(movie6);
        movieList7.addMovie(movie10);

        movieListRepository.save(movieList1);
        movieListRepository.save(movieList2);
        movieListRepository.save(movieList3);
        movieListRepository.save(movieList4);
        movieListRepository.save(movieList5);
        movieListRepository.save(movieList6);
        movieListRepository.save(movieList7);


    }
}