package com.example.cinemavericks.repositories;

import com.example.cinemavericks.models.Genre;
import com.example.cinemavericks.models.GenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenreEnum(GenreEnum genreEnum);
}
