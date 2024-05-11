package org.selfproject.cinema_app.repository;

import org.selfproject.cinema_app.model.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {
}