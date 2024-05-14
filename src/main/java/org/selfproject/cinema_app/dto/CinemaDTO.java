package org.selfproject.cinema_app.dto;


public record CinemaDTO(
    Long id,
    String name,
    Integer capacity,
    String hours,
    Boolean imax,
    Double price
) {}
