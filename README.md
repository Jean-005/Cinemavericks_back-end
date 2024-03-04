**CineMavericks**

**Bio:**

This project is an API for a film review aggregation application. Users can leave reviews with star ratings on films they have seen and curate lists of films based around any theme of their choosing. They can also search movies by genre, director etc.

**Tech Stack**

Java
SpringBoot
PostgreSQL Database

Entity Relationship Diagram (ERD) and Class Diagram: 
https://excalidraw.com/#room=4bc1651ba3f81fbe936c,Ud0mJ7-NPaNVfieqM0HqCw


**MVP:**

Design and build an API with CRUD functionality. There will be a one-to-many relationship of Movies  and Users to the Reviews.

The Movie table will have columns for:
- Id
- Title
- Year - Movie Released
- Genre
- Director

The User table will have columns for:
- Id
- name


The Review table will have columns for:
- id 
- Title
- Movie
- User
- Content
- Rating

The API must include routes enabling user to:

Create a list of movies
- Add movie
- Edit movie
- View all movies
- Get movie by id
- Get all the reviews of a movie
- Get all movie lists
- Get specific movie list by id
- Create movie list
- Update movie list
- Delete movie list
- Create review
- Edit review
- Delete review
- Get all users
- Get specific user
- Get all reviews by a specific user
- Get all lists by specific user
- Create a user
- Delete a user

Create a DataLoader to seed the database with Users, Movies and Reviews.

**EXTENSION:**
- User can set lists to private or public
- Edit a user’s information
- Display average rating of movie
- Filter movies by rating
- Display lists containing a specific film
- Allow movies to have multiple genres
- Automatically add current date to review (refactor to LocalDate)
- Allow users to leave comments and likes on reviews


