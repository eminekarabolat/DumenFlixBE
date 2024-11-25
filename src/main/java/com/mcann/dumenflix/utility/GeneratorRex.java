package com.mcann.dumenflix.utility;

import com.mcann.dumenflix.repository.MovieCardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
@RequiredArgsConstructor
public class GeneratorRex {
	private final MovieCardRepository movieCardRepository;
	@PostConstruct
	public void init() {
		var movieCards = movieCardRepository.findAll();
		for (var i = 1; i < movieCards.size()+1; i++) {
			var movie = movieCards.get(i-1);
			movie.setImageUrl("https://api.slingacademy.com/public/sample-photos/"+i+".jpeg");
			movieCardRepository.save(movie);
		}
	}
}