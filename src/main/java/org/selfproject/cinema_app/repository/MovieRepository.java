package org.selfproject.cinema_app.repository;

import org.selfproject.cinema_app.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}