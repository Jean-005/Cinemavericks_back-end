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
        User user7 = new User("Hannah");
        User user8 = new User("Ivan");
        User user9 = new User("Jasmine");
        User user10 = new User("Kai");
        User user11 = new User("Lena");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        userRepository.save(user11);

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
        List<Genre> genres13 = new ArrayList<>();
        List<Genre> genres14 = new ArrayList<>();
        List<Genre> genres15 = new ArrayList<>();
        List<Genre> genres16 = new ArrayList<>();
        List<Genre> genres17 = new ArrayList<>();

        genres1.add(comedy);
        genres1.add(adventure);
        genres2.add(thriller);
        genres2.add(action);
        genres3.add(romance);
        genres4.add(scifi);
        genres13.add(anime);
        genres13.add(fantasy);
        genres14.add(historical);
        genres14.add(thriller);
        genres15.add(comedy);
        genres15.add(action);
        genres16.add(horror);
        genres16.add(romance);
        genres17.add(action);
        genres17.add(romance);


        Movie hoodWinked = new Movie("Hoodwinked", 2005 ,genres1,"Cory Edwards", 80);
        Movie whipLash = new Movie("Whiplash", 2014,genres2, "Damien Chazelle",  107);
        Movie thisIsMeNow = new Movie("This Is Me Now", 2024,genres1,"Dave Mayers",  65);
        Movie scottPilgrimVsTheWorld = new Movie("Scott Pilgrim Vs The World", 2010,genres2,"Edgar Wright",  112);
        Movie gladiator = new Movie("Gladiator", 2000, genres14, "Ridley Scott", 155);
        Movie anchorMan = new Movie("Anchorman: The Legend of Ron Burgundy", 2004, genres15, "Adam McKay", 94);
        Movie scream = new Movie("Scream", 1996, genres16, "Wes Craven", 111);
        Movie topGun = new Movie("Top Gun", 1986, genres17, "Tony Scott", 110);

        Movie movie1 = new Movie("The Shawshank Redemption", 1994,genres2,"Frank Darabont",  142);
        Movie movie2 = new Movie("The Godfather", 1972,genres2,"Francis Ford Coppola", 175);
        Movie movie3 = new Movie("The Dark Knight", 2008,genres2,"Christopher Nolan", 152);
        Movie movie4 = new Movie("Schindler's List", 1993,genres2,"Steven Spielberg", 195);
        Movie movie5 = new Movie("Pulp Fiction", 1994,genres2,"Quentin Tarantino", 165);
        Movie movie6 = new Movie("The Lord of the Rings: The Return of the King", 2003,genres1,"Peter Jackson", 210);
        Movie movie7 = new Movie("Fight Club", 1999,genres2,"David Fincher",  139);
        Movie movie8 = new Movie("Forrest Gump", 1994,genres1,"Robert Zemeckis", 142);
        Movie movie9 = new Movie("Inception", 2010,genres1,"Christopher Nolan", 148);
        Movie movie10 = new Movie("The Matrix", 1999,genres2,"Wachowskis",  136);

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
        movieRepository.save(gladiator);
        movieRepository.save(anchorMan);
        movieRepository.save(scream);
        movieRepository.save(topGun);

        Review review1 = new Review(user3, scottPilgrimVsTheWorld, "wow so cool","FILM SO GOOD WOW WOOOOOOO!", 5);
        Review review2 = new Review(user5, movie2, "Not Great","Hmmm, it was okay. Not the best but not bad.", 2);
        Review review3 = new Review(user6, movie2, "Don't even","Don't.", 1);
        Review review4 = new Review(user7, movie1, "A classic", "One of the best movies of all time", 5);
        Review review5 = new Review(user8, movie10, "Awesome!", "The special effects are amazing!", 4);
        Review review7 = new Review(user10, gladiator, "Good", "A bit too long but still a good watch", 3);
        Review review8 = new Review(user11, anchorMan, "Okay...", "Not a big fan of comedies", 2);
        Review review9 = new Review(user1, topGun, "Love it!", "One of my all-time favorites!", 5);
        Review review10 = new Review(user5, topGun, "Not bad", "I'm not a big fan of action movies, but this one was okay.", 3);


        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);
        reviewRepository.save(review5);
        reviewRepository.save(review7);
        reviewRepository.save(review8);
        reviewRepository.save(review9);
        reviewRepository.save(review10);

        // Calculate the average rating for the movies with new reviews
        movie1 = movieRepository.findById(1L).get();
        movie1.calculateAverageRating();
        movieRepository.save(movie1);

        movie10 = movieRepository.findById(10L).get();
        movie10.calculateAverageRating();
        movieRepository.save(movie10);

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
        movieListRepository.save(movieList7);

        MovieList movieList8 = new MovieList(user7, "Fav List");
        movieList8.addMovie(movie1);
        movieList8.addMovie(movie10);
        movieListRepository.save(movieList8);

        MovieList movieList9 = new MovieList(user8, "Best List");
        movieList9.addMovie(movie10);
        movieListRepository.save(movieList9);

        MovieList movieList11 = new MovieList(user10, "Worst List");
        movieList11.addMovie(gladiator);
        movieListRepository.save(movieList11);

        MovieList movieList12 = new MovieList(user1, "Favorite Movies");
        movieList12.addMovie(topGun);
        movieListRepository.save(movieList12);

        List<Genre> genres18 = new ArrayList<>();
        List<Genre> genres19 = new ArrayList<>();
        List<Genre> genres20 = new ArrayList<>();
        List<Genre> genres21 = new ArrayList<>();

// Add genres to the new movies
        genres18.add(action);
        genres18.add(scifi);
        genres19.add(adventure);
        genres21.add(anime);
        genres21.add(action);

        Movie terminator = new Movie("The Terminator", 1984, genres18, "James Cameron", 107);
        Movie titanic = new Movie("The Titanic", 1997, genres19, "James Cameron", 194);
        Movie smurfs = new Movie("The Smurfs", 2011, genres20, "Raja Gosnell", 103);
        Movie naruto = new Movie("Naruto Shippuden The Movie", 2007, genres21, "Hayato Date", 94);

        movieRepository.save(terminator);
        movieRepository.save(titanic);
        movieRepository.save(smurfs);
        movieRepository.save(naruto);

        Review review11 = new Review(user4, titanic, "Epic", "One of the most epic love stories ever", 5);
        Review review12 = new Review(user6, terminator, "Interesting", "It was an interesting movie with good action", 4);
        Review review13 = new Review(user5, smurfs, "Cute", "Cute little creatures, fun for the kids", 3);
        Review review14 = new Review(user2, naruto, "Entertaining", "Nice anime movie with good animation", 4);

        reviewRepository.save(review11);
        reviewRepository.save(review12);
        reviewRepository.save(review13);
        reviewRepository.save(review14);

        movieList1 = movieListRepository.findById(1L).get();
        movieList1.addMovie(terminator);
        movieListRepository.save(movieList1);

        movieList2 = movieListRepository.findById(2L).get();
        movieList2.addMovie(titanic);
        movieListRepository.save(movieList2);

        movieList3 = movieListRepository.findById(3L).get();
        movieList3.addMovie(smurfs);
        movieListRepository.save(movieList3);

        movieList4 = movieListRepository.findById(4L).get();
        movieList4.addMovie(naruto);
        movieListRepository.save(movieList4);
    }
}