package org.selfproject.cinema_app.converter;

import org.mapstruct.Mapper;
import org.selfproject.cinema_app.dto.MovieDTO;
import org.selfproject.cinema_app.model.MovieEntity;



@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDTO(MovieEntity movieEntity);
    MovieEntity toEntity(MovieDTO movieDTO);
}
