package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.dto.CinemaDTO;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {

    private final CinemaRepository cinemaRepository;
    private final CinemaService cinemaService;

    CinemaController(CinemaRepository cinemaRepository, CinemaService cinemaService){
        this.cinemaRepository = cinemaRepository;
        this.cinemaService = cinemaService;
    }

    @PostMapping("/api/cinemas")
    public ResponseEntity<CinemaDTO> postCinema(@RequestBody CinemaDTO cinemaDTO){
        return new ResponseEntity<>(cinemaService.saveCinema(cinemaDTO),HttpStatus.CREATED);
    }

    @PutMapping("/api/cinemas/{id}")
    public ResponseEntity<CinemaDTO> updateCinema(@PathVariable Long id, @RequestBody CinemaDTO cinemaDTO){
        return cinemaService.updateCinema(cinemaDTO,id).map(updatedCinema->new ResponseEntity<>(updatedCinema,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("api/cinemas")
    public ResponseEntity<List<CinemaDTO>> getCinemas(){
        return new ResponseEntity<>(cinemaService.getAllCinemas(),HttpStatus.OK);
    }


    @DeleteMapping("/api/cinemas/{id}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long id){
        cinemaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/api/cinemas/{cinemaId}/movies/{movieId}")
//    public ResponseEntity<CinemaDTO> addMovieToCinema(@PathVariable Long cinemaId, @PathVariable Long movieId) {
//        return new ResponseEntity<>(cinemaService.addMovieToCinema(cinemaId, movieId), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/api/cinemas/{cinemaId}/movies/{movieId}")
//    public ResponseEntity<CinemaDTO> removeMovieFromCinema(@PathVariable Long cinemaId, @PathVariable Long movieId) {
//        return new ResponseEntity<>(cinemaService.removeMovieFromCinema(cinemaId, movieId), HttpStatus.OK);
//    }
}
