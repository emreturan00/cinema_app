package org.selfproject.cinema_app.service;

import org.selfproject.cinema_app.converter.MovieMapper;
import org.selfproject.cinema_app.dto.MovieDTO;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    MovieService(MovieRepository movieRepository, MovieMapper movieMapper){
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> getAllMovies(){
        return movieRepository
                .findAll()
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());

    }

    public MovieDTO saveMovie(MovieDTO movieDTO){
        MovieEntity movieEntity = movieRepository.save(movieMapper.toEntity(movieDTO));
        return movieMapper.toDTO(movieEntity);
    }

    public Optional<MovieDTO> updateMovie(MovieDTO movieDTO,Long id){
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(id);
        if(optionalMovieEntity.isPresent()){
            MovieEntity existingMovieEntity = optionalMovieEntity.get();
            MovieEntity newMovieEntity = movieMapper.toEntity(movieDTO);

            existingMovieEntity.setName(newMovieEntity.getName());
            existingMovieEntity.setDuration(newMovieEntity.getDuration());
            existingMovieEntity.setGenre(newMovieEntity.getGenre());
            existingMovieEntity.setRating(newMovieEntity.getRating());
            existingMovieEntity.setCast(newMovieEntity.getCast());
            existingMovieEntity.setDirector(newMovieEntity.getDirector());
            existingMovieEntity.setImageLocation(newMovieEntity.getImageLocation());
            existingMovieEntity.setReleaseDate(newMovieEntity.getReleaseDate());

            MovieEntity updatedMovieEntity = movieRepository.save(existingMovieEntity);
            return Optional.of(movieMapper.toDTO(updatedMovieEntity));
        }
        else {
            return Optional.empty();
        }
        }
}
