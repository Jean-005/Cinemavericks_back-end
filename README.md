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

The motivation behind this project is to foster a dynamic and engaging platform where users can interact with films in a meaningful and personalized manner. This project have been created as part of BNTA (Bright Network Technology Academy) Cohort 13 Group 3 Collaboration Backend Project.

<a id="installation"></a>
## Installation Instruction
1. Have a Java IDE, POSTMAN, Postico, PostgreSQL Installed
2. Fork Project to your GitHub/Clone Project to your local computer
3. Open the project in an IDE
4. Run the application and server
5. Create database 'cinemavericks_db' in your terminal/Gitbash (local computer)
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

Design and build an API with CRUD functionality. There will be a one-to-many relationship of Movies  and Users to the Reviews.

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



**MVP Class Diagram**

![Class Diagram](https://github.com/GJaradat/cinemavericks/assets/99983599/b29bdc72-cbe0-4fcf-b04e-20855d46e95f)


**MVP ERD Diagram**

![ERD Diagram](https://github.com/GJaradat/cinemavericks/assets/99983599/3ae17da8-7d76-4c66-a0eb-9bf78b57b141)


<a id="extension"></a>
## EXTENSION:
- Movie has a duration property
- User can filter movie search by duration

- Give movies an average rating property
- Filter movies by average rating
- Round average rating to 2dp

- Edit a user’s information
- User can set lists to private or public
- Display lists containing a specific film

- Automatically add current date to review (refactor to LocalDateTime)
- Order movies reviews by oldest/newest created
- Order user reviews by oldest/newest created

- Allow movies to have multiple genres
- Allow users to leave comments and likes on reviews
- User is able to toggle their movie list to public or private
- The get movielist request only shows public movielists (when a user searches for their movielists they can still see their private ones though)

<a id="class-erd-diagram"></a>
## Class Diagram and ERD Diagram:
**Class Diagram for CinemaMavericks**
![Class Diagram for CinemaMavericks](https://github.com/GJaradat/cinemavericks/assets/108727885/ace8874d-3191-43cd-b6e7-e72ba3503ab4)

**ERD Diagram for CinemaMavericks**
![ERD Diagram for CinemaMavericks](https://github.com/GJaradat/cinemavericks/assets/99983599/164bec3e-21f3-41a7-bfde-8e973acea3bc)

Entity Relationship Diagram (ERD) and Class Diagram - Both MVP and Extension :
https://excalidraw.com/#room=4bc1651ba3f81fbe936c,Ud0mJ7-NPaNVfieqM0HqCw



<a id="data-dictionary"></a>
## Data Dictionary for CinemaMavericks

**Movies Table**

| Column Name | Description                 | Data Type    | Permitted Values |
|-------------|-----------------------------|--------------|------------------|
| id          | Unique identifier           | SERIAL       | numbers >= 1     |
| title       | Title of the movie          | VARCHAR(255) |                  |
| year        | Year of movie release       | INT          |                  |
| genre       | Genre of the movie          | VARCHAR(255) |                  |
| director    | Director of the movie       | VARCHAR(255) |                  |

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
| rating      | Rating given to the movie           | INT          | 0 <= value <= 5                 |
| movie_id    | ID of movie being reviewed          | BIGINT       | Foreign Key ```movies.id```     |
| user_id     | ID of user leaving review           | BIGINT       | Foreign Key ```users.id```      |


**Movie Lists Table**

| Column Name | Description                       | Data Type    | Permitted Values            | 
|-------------|-----------------------------------|--------------|-----------------------------|
| id          | Unique identifier                 | SERIAL       | numbers >= 1                |
| title       | Title of the movie list           | VARCHAR(255) |                             |  
| user_id     | ID of User who created the list   | BIGINT       | Foreign Key ```users.id```  |


**Movies Movie Lists Table**

| Column Name | Description                                          | Data Type    | Permitted Values                  |
|-------------|------------------------------------------------------|--------------|-----------------------------------|
| id          | Unique identifier                                    | SERIAL       | numbers >= 1                      |
| movielist_id| ID referencing movie list in Movie Lists table       | BIGINT        | Foreign Key ```movies_lists.id```|
| movie_id    | ID referencing movie in Movie table                  | BIGINT       | Foreign Key ```movies.id```       |


 <a id="api-routes-table"></a>
## API Routes Table

| Route Name                    | URL                                   | Example Permitted Request                          | Example Response         |
|-------------------------------|---------------------------------------|----------------------------------------------------|--------------------------|
| Movie Index	                  | /movies	                            	| GET /movies                	                       | { "movies": [...] }      |
| View Movie	                  | /movies/:id	                        	| GET /movies/movie123	                             | { "id": [...] }          |
| Add Movie	                    | /movies	                            	| POST /movies	                                     | { "id": [...] }          |
| Edit Movie	                  | /movies/:id	                          | PATCH /movies/movie123	                           | { "id": [...] }          |
| Reviews of a Movie	          | /movies/:id/reviews	                  | GET /movies/movie123/reviews	                     | { "reviews": [...] }     |
| Movie Lists containing Movie	| /movies/:id/movieLists	              | GET /movies/movie123/movieLists	                   | { "movieLists": [...] }  |
| Filter movies by rating	      | /movies?minRating	                    | GET	/movies?minRating=4	                           | { "movies": [...] }      |
| Filter movies by genre	      | /movies/filterByGenre?genre	          | GET /movies/filterByGenre?genre=action	           | { "movies": [...] }      |
| Filter movies by duration	    | /movies/filterByDuration?minDuration	| GET /movies/filterByDuration?minDuration=120	     | { "movies": [...] }      |
| Sort reviews by time	        | /movies/:id/reviews/sort?timeOrder	 	| GET /movies/movie123/reviews/sort?timeOrder=newest | { "reviews": [...] }     |



## Contributions
