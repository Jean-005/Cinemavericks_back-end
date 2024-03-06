package com.example.cinemavericks.components;

import com.example.cinemavericks.models.*;
import com.example.cinemavericks.repositories.MovieListRepository;
import com.example.cinemavericks.repositories.MovieRepository;
import com.example.cinemavericks.repositories.ReviewRepository;
import com.example.cinemavericks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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

        Movie hoodWinked = new Movie("Hoodwinked", 2005 , Genre.COMEDY, "Cory Edwards", 80);
        Movie whipLash = new Movie("Whiplash", 2014, Genre.THRILLER,"Damien Chazelle",  107);
        Movie thisIsMeNow = new Movie("This is Me Now", 2024,Genre.ROMANCE,"Dave Mayers",  65);
        Movie scottPilgrimVsTheWorld = new Movie("Scott Pilgrim Vs The World", 2010, Genre.COMEDY,"Edgar Wright",  112);

        Movie movie1 = new Movie("The Shawshank Redemption", 1994, Genre.THRILLER,"Frank Darabont",  142);
        Movie movie2 = new Movie("The Godfather", 1972, Genre.THRILLER,"Francis Ford Coppola", 175);
        Movie movie3 = new Movie("The Dark Knight", 2008, Genre.ACTION,"Christopher Nolan", 152);
        Movie movie4 = new Movie("Schindler's List", 1993, Genre.THRILLER,"Steven Spielberg", 195);
        Movie movie5 = new Movie("Pulp Fiction", 1994, Genre.ACTION,"Quentin Tarantino", 165);
        Movie movie6 = new Movie("The Lord of the Rings: The Return of the King", 2003, Genre.FANTASY,"Peter Jackson",  210);
        Movie movie7 = new Movie("Fight Club", 1999, Genre.COMEDY,"David Fincher",  139);
        Movie movie8 = new Movie("Forrest Gump", 1994, Genre.COMEDY,"Robert Zemeckis",  142);
        Movie movie9 = new Movie("Inception", 2010, Genre.SCIFI,"Christopher Nolan",  148);
        Movie movie10 = new Movie("The Matrix", 1999, Genre.SCIFI,"Wachowskis",  136);

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