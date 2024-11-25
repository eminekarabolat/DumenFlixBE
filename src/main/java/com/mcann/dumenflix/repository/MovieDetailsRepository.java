package com.mcann.dumenflix.repository;

import com.mcann.dumenflix.entity.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
}