package com.mcann.dumenflix.utility;

import com.mcann.dumenflix.entity.MovieDetails;
import com.mcann.dumenflix.repository.MovieCardRepository;
import com.mcann.dumenflix.repository.MovieDetailsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeneratorRex {
	private final MovieCardRepository movieCardRepository;
	private final MovieDetailsRepository movieDetailsRepository;
	/*@PostConstruct
	public void init() {
		var movieCards = movieCardRepository.findAll();
		for (var i = 1; i < movieCards.size()+1; i++) {
			var movie = movieCards.get(i-1);
			movie.setImageUrl("https://api.slingacademy.com/public/sample-photos/"+i+".jpeg");
			movieCardRepository.save(movie);
		}
	}*/
	/*@PostConstruct
	public void init(){
		List<String> videoUrlList = List.of("https://www.youtube.com/watch?v=5lzoxHSn0C0",
		                          "https://www.youtube.com/watch?v=DCWcK4c-F8Q",
		                          "https://www.youtube.com/watch?v=Ed1sGgHUo88",
		                          "https://www.youtube.com/watch?v=1pHDWnXmK7Y",
		                          "https://www.youtube.com/watch?v=NOhDyUmT9z0",
		                          "https://www.youtube.com/watch?v=Bw8ZdQpVtdU",
		                          "https://www.youtube.com/watch?v=Z2gCPKDICFU",
		                          "https://www.youtube.com/watch?v=mwlrFeuMC6o",
		                          "https://www.youtube.com/watch?v=Ax6B3s4SQLg",
		                          "https://www.youtube.com/watch?v=W9jmwTK-yJ8",
		                          "https://www.youtube.com/watch?v=eknj5_0tF2s",
		                          "https://www.youtube.com/watch?v=wikP5QsikJ4",
		                          "https://www.youtube.com/watch?v=yLxoVrFpLmQ",
		                          "https://www.youtube.com/watch?v=iTYVJmoqVEM",
		                          "https://www.youtube.com/watch?v=f19gfOMZTtg",
		                          "https://www.youtube.com/watch?v=wJO_vIDZn-I&pp=ygUPbWluZWNyYWZ0IG1vdmll",
		                          "https://www.youtube.com/watch?v=LH1J1EbqCaI&pp=ygUPbWluZWNyYWZ0IG1vdmll",
		                          "https://www.youtube.com/watch?v=dKnJ3rDgX9I&pp=ygURbWF0cml4IGZ1bGwgbW92aWU%3D",
		                          "https://www.youtube.com/watch?v=1F3OGIFnW1k",     "https://www.youtube.com/watch?v=8-NEOVSEvCk",     "https://www.youtube.com/watch?v=AGgfFGrN88s",     "https://www.youtube.com/watch?v=cCMNXfjPAZ0",     "https://www.youtube.com/watch?v=-WlSylEzlgQ", "https://www.youtube.com/watch?v=XGGXlj6grzQ", "https://www.youtube.com/watch?v=b0CjyyI-Kqc");
		var movieDetails = movieDetailsRepository.findAll();
		for (int i = 0; i < movieDetails.size(); i++) {
			MovieDetails md = movieDetails.get(i);
			md.setVideoUrl(videoUrlList.get(i % videoUrlList.size()));
		}
		movieDetailsRepository.saveAll(movieDetails);
	}*/
}