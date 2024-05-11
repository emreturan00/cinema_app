package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @PostMapping("/api/movies")
    public ResponseEntity<MovieEntity> postCinema(@RequestBody MovieEntity movieEntity){
        MovieEntity createdMovie = movieRepository.save(movieEntity);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }
}
