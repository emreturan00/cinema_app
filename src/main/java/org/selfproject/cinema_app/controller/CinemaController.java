package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    CinemaController(CinemaRepository cinemaRepository, MovieRepository movieRepository){
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/api/getCinemas")
    public List<CinemaEntity> getCinemas(){
        List<CinemaEntity> cinemas = cinemaRepository.findAll();
        return cinemas;
    }

    @PostMapping("/api/cinemas")
    public ResponseEntity<CinemaEntity> postCinema(@RequestBody CinemaEntity cinemaEntity){
        CinemaEntity createdCinema = cinemaRepository.save(cinemaEntity);
        return new ResponseEntity<>(createdCinema, HttpStatus.CREATED);
    }

    @PutMapping("/api/cinemas/{cinemaId}/movies/{movieId}")
    public ResponseEntity<CinemaEntity> addMovieToCinema(@PathVariable Long cinemaId, @PathVariable Long movieId){
        CinemaEntity cinema = cinemaRepository.findById(cinemaId).get();
        MovieEntity movie = movieRepository.findById(movieId).get();
        cinema.getPlayingMovies().add(movie);
        CinemaEntity updatedCinema = cinemaRepository.save(cinema);
        return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
    }
}
