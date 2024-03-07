![CineMavericks-07-03-2024 (3)](https://github.com/GJaradat/cinemavericks/assets/92640386/6473adbb-7f5b-4689-85f6-666f0cb6e22b)
![Like-TopGun-but-for-movies-07-03-2024 (1)](https://github.com/GJaradat/cinemavericks/assets/92640386/93e931aa-3c40-44d6-88bf-23473c52fca8)


![Axolotl at the cinemas](https://github.com/GJaradat/cinemavericks/assets/108727885/38e385b5-6cb2-4b21-a2c7-7147facb727d)

## Table of Contents
1. [Introduction](#introduction)
2. [Installation Instruction](#installation)
3. [Technology](#technology)
4. [MVP](#mvp)
7. [Extension](#extension)
8. [Class and ERD Diagram](#class-erd-diagram)
9. [Data Dictionary](#data-dictionary)
10. [Api Route Table (Usage)](#api-routes-table)


<a id="introduction"></a>
## Introduction

This project involves creating an API for a film review aggregation platform, which incorporates a comprehensive movie database. Users can leave reviews with star ratings on films they have seen and curate lists of films based around any theme of their choosing. Additionally, they have the capability to explore movies by genre, director, and other relevant criteria.

The motivation behind this project is to create a dynamic and engaging platform where users can interact with other cinephiles in a meaningful and personalized manner. This project have been created as part of a BNTA (Bright Network Technology Academy) Cohort 13 Collaboration Backend Project.

<a id="installation"></a>
## Installation Instruction
1. Have a Java IDE, POSTMAN, Postico, PostgreSQL Installed
2. Fork Project to your GitHub/Clone Project to your local computer
3. Open the project in an IDE
4. Create database 'cinemavericks_db' in your terminal/Gitbash (local computer)
5. Run the application and server
5. Use POSTMAN to use or test the endpoints (use the provided postman collection found in GitHub repo)

<a id="technology"></a>
## Technology
Purpose of Technology usage:
The objective is to enhance learning and skill development as an integral component of the bootcamp experience hence why the following technologies were used.

**Tech Stack:**
- Java
- SpringBoot
- PostgreSQL Database

**The Spring Boot Libraries used:**
- Maven Project
- Spring Boot: Ver. 3.2.3
- Spring Boot Dev Tools
- Spring Web
- PostgreSQL Driver
- Spring Data JPA

**Tools Used:**
- POSTMAN
- Intellij
- Trello
- Excalidraw
- Zoom
- Slack
- Git

<a id="mvp"></a>
## MVP

Design and build an API with CRUD functionality. The database will store ```Movies```, ```Users```, ```Reviews``` (left by ```Users``` about ```Movies```) and ```MovieLists``` created by ```Users```. All ```Reviews``` and ```MovieLists``` will be attached to a specific ```User``` and these should be viewable from their "profile". One should also be able to retrieve all ```Reviews``` of a specific ```Movie```. This functionality will be achieved through a series of one-to-many and many-to-many relationships between these entities, as detailed by the ERD below.


**MVP Class Diagram**

![Class Diagram](https://github.com/GJaradat/cinemavericks/assets/99983599/b29bdc72-cbe0-4fcf-b04e-20855d46e95f)


**MVP ERD Diagram**

![ERD Diagram](https://github.com/GJaradat/cinemavericks/assets/99983599/3ae17da8-7d76-4c66-a0eb-9bf78b57b141)


<a id="extension"></a>
## EXTENSIONS:
- Give ```Movie``` a duration property and write a ```GET``` request that returns ```Movie``` objects filtered by duration

- Calculate an ```averageRating``` property for each ```Movie``` based on its asscoiated ```Review```s. This should be rounded to 2 decimal places.
- Write ```GET``` endpoint that that returns ```Movie``` objects filtered by average rating

- Write ```PATCH``` request to edit properties of a ```User```
- Write ```PATCH``` method to set ```MovieList``` private or public

- Display all ```MovieList```s containing a specific ```Movie```

- Automatically add current date to review (refactor to ```LocalDateTime```)
- Order ```Review```s of a certain ```Movie``` by oldest/newest created
- Order ```Review```s by a certain ```User``` by oldest/newest created

- Allow movies to have more than one ```Genre```
- Write ```GET``` request that returns all ```Movie``` objects of a specified ```Genre```

- ```MovieList``` can be set to public or private and only public ones are displayed by INDEX route
- Accessing all ```MovieList```s of a ```User``` will display both public and private ```MovieList```
  
- Allow users to leave comments and likes on reviews (coming soon!)

<a id="class-erd-diagram"></a>
## Final Class Diagram and ERD Diagram:
**Class Diagram for CinemaMavericks**
![Final Class Diagram](https://github.com/moneshadhali/cinemavericks/assets/99983599/d2c3a71f-e745-47b5-8c4d-42f3f992a596)

**ERD Diagram for CinemaMavericks**
![Final ERD Diagram](https://github.com/moneshadhali/cinemavericks/assets/99983599/8bf2778a-a177-40c3-886e-b1540eea8f4d)

Entity Relationship Diagram (ERD) and Class Diagram - Both MVP and Extension :
https://excalidraw.com/#room=4bc1651ba3f81fbe936c,Ud0mJ7-NPaNVfieqM0HqCw



<a id="data-dictionary"></a>
## Data Dictionary for CinemaMavericks

**Movies Table**

| Column Name | Description                 | Data Type    | Permitted Values |
|-------------|-----------------------------|--------------|------------------|
| id          | Unique identifier           | SERIAL       | numbers >= 1     |
| title       | Title of the movie          | VARCHAR(255) |                  |
| year        | Year of movie release       | BIGINT       |                  |
| director    | Director of the movie       | VARCHAR(255) |                  |
| duration    | Duration of the movie       | INT          |                  |
| average_rating    | Average rating based on reviews       | DOUBLE |                  |

**Users Table**

| Column Name | Description               | Data Type    | Permitted Values |
|-------------|---------------------------|--------------|------------------|
| id          | Unique identifier         | SERIAL       | numbers >= 1     |
| name        | Name of the user          | VARCHAR(255) |                  |

**Reviews Table**

| Column Name | Description                         | Data Type    | Permitted Values                |
|-------------|-------------------------------------|--------------|---------------------------------|
| id          | Unique identifier                   | SERIAL       | numbers >= 1                    |
| title       | Title of the review                 | VARCHAR(255) |                                 |
| content     | Content of the review               | TEXT         |                                 |
| rating      | Rating given to the movie           | DOUBLE       | 0 <= value <= 5                 |
| date        | Date and time review was posted     | DATETIME     |                                 |
| movie_id    | ID of movie being reviewed          | BIGINT       | Foreign Key ```movies.id```     |
| user_id     | ID of user leaving review           | BIGINT       | Foreign Key ```users.id```      |

**Movie Lists Table**

| Column Name | Description                       | Data Type    | Permitted Values            | 
|-------------|-----------------------------------|--------------|-----------------------------|
| id          | Unique identifier                 | SERIAL       | numbers >= 1                |
| title       | Title of the movie list           | VARCHAR(255) |                             |  
| user_id     | ID of User who created the list   | BIGINT       | Foreign Key ```users.id```  |

**Genres Table**

| Column Name | Description                 | Data Type    | Permitted Values |
|-------------|-----------------------------|--------------|------------------|
| id          | Unique identifier           | SERIAL       | numbers >= 1     |
| genre       | Genre from the Genre Enum         | ENUM |                  |


<a id="api-route-table"></a>
## API Routes Table
 **MovieAPI Routes**

| Route Name                    | URL                                   | Example Permitted Request                          | Example Response         |
|-------------------------------|---------------------------------------|----------------------------------------------------|--------------------------|
| Movie Index	                  | localhost:8080movies	                            	| GET /movies                	                       | { "movies": [...] }      |
| View Movie	                  | localhost:8080/movies/:id	                        	| GET /movies/movie1                                 | { "id": [...] }          |
| Add Movie	                    | localhost:8080/movies	                            	| POST /movies	                                     | { "id": [...] }          |
| Edit Movie	                  | localhost:8080/movies/:id	                          | PATCH /movies/1  	                                 | { "id": [...] }          |
| Reviews of a Movie	          | localhost:8080/movies/:id/reviews	                  | GET /movies/1/reviews	                             | { "reviews": [...] }     |
| Movie Lists containing Movie	| localhost:8080/movies/:id/movieLists	              | GET /movies/movie1/movieLists	                     | { "movieLists": [...] }  |
| Filter movies by rating	      | localhost:8080/movies?minRating	                    | GET	/movies/filterByRating	                       | { "movies": [...] }      |
| Filter movies by genre	      | localhost:8080/movies/filterByGenre?genre=?	        | GET /movies/filterByGenre?genre=COMEDY	           | { "movies": [...] }      |
| Filter movies by duration	    | localhost:8080/movies/filterByDuration?minDuration	| GET /movies/filterByDuration                	     | { "movies": [...] }      |
| Sort reviews by time	        | localhost:8080/movies/:id/reviews/sort?timeOrder	 	| GET /movies/10/reviews/sortnewest                  | { "reviews": [...] }     |
| Movie's movieLists  	        | localhost:8080/movies/:id/movieLists	 	            | GET /movies/10/movieLists                          | { "movieLists": [...] }  |

**UserAPI Routes**

| Route Name                              | URL                                | Example Permitted Request                        | Example Response         |
|-----------------------------------------|------------------------------------|--------------------------------------------------|--------------------------|
| Get all Users                           | localhost:8080/users                             | GET /users                	                      | { "id": "1", ... }, ...  |
| Get specific User	                      | localhost:8080/users/:id                       	 | GET /users/1	                                    | { "id": "1", ... }       |
| Get all Reviews by User                 | localhost:8080/users/:id/reviews                 | GET /users/1/reviews                             | { "id": "review1",...}   |
| Get all Reviews by User Sorted by Time	| localhost:8080/users/:id/reviews/sortnewest      | GET /users/2/reviews/sortnewest                  | { "id": "review1", ... } |
| Get all MovieLists by User	            | localhost:8080/users/:id/movieLists              | GET /users/1/movieLists                           | { "id": "1", ... }      |
| Post User	                              | localhost:8080/users	                           | POST /users	                                    | { "id": "user100", ... } |
| Delete User	                            | localhost:8080/users/:id	                       | DELETE /users/6	                                | No Content               |
| Patch User	                            | localhost:8080/users/:id                         | PATCH /users/7	                                  | { "id": "user1", ... }   |


**ReviewAPI Routes**

| Route Name                              | URL                                | Example Permitted Request                        | Example Response         |
|-----------------------------------------|------------------------------------|--------------------------------------------------|--------------------------|
| Post Review                             | localhost:8080/reviews             | POST /reviews                	                  | { "id": ...}             |
| Patch Review	                          | localhost:8080/reviews/:id         | PATCH /reviews/4                                 | { "id": "review4", ... } |
| Delete Review                           | localhost:8080/reviews/:id         | DELETE /reviews/1                                | No Content               |

**MovieListsAPI Routes**

| Route Name                              | URL                                | Example Permitted Request                        | Example Response         |
|-----------------------------------------|------------------------------------|--------------------------------------------------|--------------------------|
| Get all MovieLists (only public ones)   | localhost:8080/movielists                        | GET /movielists                	                | { "id": "list1", ... }   |
| Get specific MovieList                  | localhost:8080/movielists/:id                    | GET /movielists/1                                | { "id": "title", ... }   |
| Post MovieList                          | localhost:8080/movielists                        | POST /movielists                                 | { "id": "title", ... }   |
| Toggle movie list privacy setting	      | localhost:8080/movielists/:id/setPublic?         | PATCH /movielists/8/setPublicfalse               | { "id": "title", ... }   |
| Add movie to List                       | localhost:8080/movielists/:id/addMovies	         | PATCH /movielists/1/addMovies                    | { "id": ..., "movies" }  |
| Remove movie from List                  | localhost:8080/movielists/:id/removeMovies	     | PATCH /movielists/1/removeMovies                 | { "id": ..., "movies" }  |
| Delete movielist                        | localhost:8080/movielists/:id/            	     | PATCH /movielists/1/                             | MovieList Deleted        |



