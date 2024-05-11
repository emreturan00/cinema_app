package org.selfproject.cinema_app.controller;

import com.mysql.cj.conf.url.LoadBalanceDnsSrvConnectionUrl;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("api/movies/{id}")
    public ResponseEntity<MovieEntity> updateMovie(@PathVariable Long id, @RequestBody MovieEntity movieEntity){
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(id);
        if(optionalMovieEntity.isPresent()){
            MovieEntity existingMovieEntity = optionalMovieEntity.get();
            existingMovieEntity.setName(movieEntity.getName());
            existingMovieEntity.setGenre(movieEntity.getGenre());
            existingMovieEntity.setRating(movieEntity.getRating());
            existingMovieEntity.setDuration(movieEntity.getDuration());
            movieRepository.save(existingMovieEntity);
            return new ResponseEntity<>(existingMovieEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/movies")
    public List<MovieEntity> getMovie(){
        List<MovieEntity> movies = movieRepository.findAll();
        return movies;
    }

    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
