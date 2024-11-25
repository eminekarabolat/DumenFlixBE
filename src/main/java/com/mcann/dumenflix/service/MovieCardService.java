package com.mcann.dumenflix.service;

import com.mcann.dumenflix.entity.MovieCard;
import com.mcann.dumenflix.entity.MovieDetails;
import com.mcann.dumenflix.repository.MovieCardRepository;
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
}