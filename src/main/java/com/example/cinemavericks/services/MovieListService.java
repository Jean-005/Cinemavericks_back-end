package com.example.cinemavericks.services;

import com.example.cinemavericks.repositories.MovieListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieListService {
    @Autowired
    MovieListRepository movieListRepository;
}
