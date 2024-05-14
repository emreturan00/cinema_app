package org.selfproject.cinema_app.dto;

public record MovieDTO(
        Long id,
        String name,
        String imageLocation,
        String cast,
        String director,
        String genre,
        String releaseDate,
        Float rating,
        String duration
) {}
