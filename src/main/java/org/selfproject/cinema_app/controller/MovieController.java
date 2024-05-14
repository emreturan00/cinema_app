package org.selfproject.cinema_app.controller;

import com.mysql.cj.conf.url.LoadBalanceDnsSrvConnectionUrl;
import org.selfproject.cinema_app.converter.MovieMapper;
import org.selfproject.cinema_app.dto.MovieDTO;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.selfproject.cinema_app.service.MovieService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    private final MovieService movieService;

    MovieController(MovieRepository movieRepository, MovieService movieService){
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @PostMapping("/api/movies")
    public ResponseEntity<MovieDTO> postMovie(@RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.saveMovie(movieDTO),HttpStatus.CREATED);
    }

    @PutMapping("/api/movies/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return movieService.updateMovie(movieDTO,id).map(updatedMovie->new ResponseEntity<>(updatedMovie,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("api/movies")
    public ResponseEntity<List<MovieDTO>> getMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }


    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
