package org.selfproject.cinema_app.service;

import org.selfproject.cinema_app.converter.CinemaMapper;
import org.selfproject.cinema_app.converter.MovieMapper;
import org.selfproject.cinema_app.dto.CinemaDTO;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;
    private final MovieMapper movieMapper;


    CinemaService(CinemaRepository cinemaRepository, CinemaMapper cinemaMapper, MovieMapper movieMapper){
        this.cinemaRepository = cinemaRepository;
        this.cinemaMapper = cinemaMapper;
        this.movieMapper = movieMapper;
    }

    public List<CinemaDTO> getAllCinemas(){
        return cinemaRepository
                .findAll()
                .stream()
                .map(cinemaMapper::toDTO)
                .collect(Collectors.toList());

    }

    public CinemaDTO saveCinema(CinemaDTO cinemaDTO){
        CinemaEntity cinemaEntity = cinemaRepository.save(cinemaMapper.toEntity(cinemaDTO));
        return cinemaMapper.toDTO(cinemaEntity);
    }

    public Optional<CinemaDTO> updateCinema(CinemaDTO cinemaDTO, Long id) {
        Optional<CinemaEntity> optionalCinemaEntity = cinemaRepository.findById(id);
        if (optionalCinemaEntity.isPresent()) {
            CinemaEntity existingCinemaEntity = optionalCinemaEntity.get();
            CinemaEntity newCinemaEntity = cinemaMapper.toEntity(cinemaDTO);

            existingCinemaEntity.setName(newCinemaEntity.getName());
            existingCinemaEntity.setName(newCinemaEntity.getName());
            existingCinemaEntity.setCapacity(newCinemaEntity.getCapacity());
            existingCinemaEntity.setHours(newCinemaEntity.getHours());
            existingCinemaEntity.setImax(newCinemaEntity.getImax());
            existingCinemaEntity.setPrice(newCinemaEntity.getPrice());


            CinemaEntity updatedCinemaEntity = cinemaRepository.save(existingCinemaEntity);
            return Optional.of(cinemaMapper.toDTO(updatedCinemaEntity));
        } else {
            return Optional.empty();
        }
    }

}
