package com.mcann.dumenflix.repository;

import com.mcann.dumenflix.entity.MovieCard;
import com.mcann.dumenflix.utility.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCardRepository extends JpaRepository<MovieCard, Long> {
	List<MovieCard> findAllByGenre(Genre genre);
	List<MovieCard> findAllByTitleContainingIgnoreCase(String title);
}