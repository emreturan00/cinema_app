package org.selfproject.cinema_app.converter;

import org.selfproject.cinema_app.dto.CinemaDTO;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CinemaMapper {
    CinemaDTO toDTO(CinemaEntity cinemaEntity);
    CinemaEntity toEntity(CinemaDTO cinemaDTO);
}
