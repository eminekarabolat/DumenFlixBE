package com.mcann.dumenflix.service;

import com.mcann.dumenflix.entity.MovieCard;
import com.mcann.dumenflix.entity.MovieDetails;
import com.mcann.dumenflix.repository.MovieCardRepository;
import com.mcann.dumenflix.utility.enums.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCardService {
	private final MovieCardRepository movieCardRepository;
	
	public List<MovieCard> getAllMovies(){
		return movieCardRepository.findAll();
	}
	
	public List<MovieCard> getMoviesByGenre(Genre genre) {
		return movieCardRepository.findAllByGenre(genre);
	}
	
	public List<MovieCard> getMoviesByName(String name) {
		return movieCardRepository.findAllByTitleContainingIgnoreCase(name);
	}
}