package com.mcann.dumenflix.repository;

import com.mcann.dumenflix.entity.MovieCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCardRepository extends JpaRepository<MovieCard, Long> {
}