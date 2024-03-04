## CineMavericks

**Bio:**

This project is an API for a film review aggregation application. Users can leave reviews with star ratings on films they have seen and curate lists of films based around any theme of their choosing. They can also search movies by genre, director etc.

**Tech Stack:**
- Java
- SpringBoot
- PostgreSQL Database

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

- View all movies
- Get movie by id
- Add movie
- Edit movie
- Get all the reviews of a movie

- Create review
- Edit review
- Delete review

- Get all users
- Get specific user
- Get all reviews by a specific user
- Get all movie lists by specific user
- Create a user
- Delete a user
  
- Get all movie lists
- Get specific movie list by id
- Create movie list
- Update movie list
- Delete movie list


Create a DataLoader to seed the database with Users, Movies and Reviews.

**EXTENSION:**
- User can set lists to private or public
- Edit a user’s information
- Give movies an average rating property
- Filter movies by average rating
- Display lists containing a specific film
- Allow movies to have multiple genres
- Automatically add current date to review (refactor to LocalDate)
- Allow users to leave comments and likes on reviews


### Class Diagram for CinemaMavericks
![Class Diagram for CinemaMavericks](https://github.com/GJaradat/cinemavericks/assets/99983599/5c99d09f-2a65-4b2a-aeb1-3062a65e8f87)


### ERD Diagram for CinemaMavericks
![ERD Diagram for CinemaMavericks](https://github.com/GJaradat/cinemavericks/assets/99983599/164bec3e-21f3-41a7-bfde-8e973acea3bc)


### Data Dictionary for CinemaMavericks
#### Movie Table

| Column Name | Description                 | Data Type    | Permitted Values |
|-------------|-----------------------------|--------------|------------------|
| id          | Unique identifier           | SERIAL       | numbers >= 1     |
| title       | Title of the movie          | VARCHAR(255) |                  |
| year        | Year of movie release       | INT          |                  |
| genre       | Genre of the movie          | VARCHAR(255) |                  |
| director    | Director of the movie       | VARCHAR(255) |                  |

#### User Table

| Column Name | Description               | Data Type    | Permitted Values |
|-------------|---------------------------|--------------|------------------|
| id          | Unique identifier         | SERIAL       | numbers >= 1     |
| name        | Name of the user          | VARCHAR(255) |                  |

#### Review Table

| Column Name | Description                         | Data Type    | Permitted Values                |
|-------------|-------------------------------------|--------------|---------------------------------|
| id          | Unique identifier                   | SERIAL       | numbers >= 1                    |
| title       | Title of the review                 | VARCHAR(255) |                                 |
| content     | Content of the review               | TEXT         |                                 |
| rating      | Rating given to the movie           | INT          | 1 <= value <= 5                 |
| movie_id    | ID referencing movie in Movie table | INT          | Foreign Key (Movie.id)          |
| user_id     | ID referencing user in User table   | INT          | Foreign Key (User.id)           |


#### Movie List Table

| Column Name | Description                       | Data Type    | Permitted Values      | 
|-------------|-----------------------------------|--------------|-----------------------|
| id          | Unique identifier                 | SERIAL       | numbers >= 1          |
| title       | Title of the movie list           | VARCHAR(255) |                       |
| user_id     | ID referencing user in User table | INT          | Foreign Key (User.id) |


#### Movie Movie Lists Table

| Column Name | Description                                          | Data Type    | Permitted Values                  |
|-------------|------------------------------------------------------|--------------|-----------------------------------|
| id          | Unique identifier                                    | SERIAL       | numbers >= 1                      |
| movielist_id | ID referencing movie list in Movie Lists table     | INT          | Foreign Key (MovieList.id)      |
| movie_id    | ID referencing movie in Movie table                  | INT          | Foreign Key (Movie.id)            |

