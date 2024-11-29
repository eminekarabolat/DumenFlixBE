package com.mcann.dumenflix.service;

import com.mcann.dumenflix.entity.MovieDetails;
import com.mcann.dumenflix.exception.DumenFlixApplicationException;
import com.mcann.dumenflix.exception.ErrorType;
import com.mcann.dumenflix.repository.MovieDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieDetailsService {
	private final MovieDetailsRepository movieDetailsRepository;
	
	public MovieDetails findById(Long id){
		Optional<MovieDetails> movieDetails = movieDetailsRepository.findById(id);
		if (movieDetails.isEmpty())
			throw new DumenFlixApplicationException(ErrorType.NOT_FOUND_MOVIE);
		return movieDetails.get();
	}
}