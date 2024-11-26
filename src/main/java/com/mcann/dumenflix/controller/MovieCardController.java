package com.mcann.dumenflix.controller;

import static com.mcann.dumenflix.constant.RestApis.*;

import com.mcann.dumenflix.dto.request.MovieFilterRequestDto;
import com.mcann.dumenflix.dto.response.BaseResponse;
import com.mcann.dumenflix.entity.MovieCard;
import com.mcann.dumenflix.service.MovieCardService;
import com.mcann.dumenflix.utility.enums.Genre;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieCardController {
	private final MovieCardService movieCardService;
	
	@GetMapping(MOVIELIST)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getAllMovies() {
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
				                         .code(200)
				                         .data(movieCardService.getAllMovies())
				                         .message("Success")
				                         .success(true)
		                                 .build()
		);
	}
	
	@GetMapping(MOVIEBYGENRE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getMoviesByGenre(Genre genre) {
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getMoviesByGenre(genre))
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
	
	@GetMapping(MOVIEBYTITLE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getMoviesByName(String name){
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getMoviesByName(name))
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
	@GetMapping(TOPRATEDMOVIE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getTopRatedMovies(){
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getTopRatedMovies())
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
	
	@PostMapping(FILTERMOVIE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getMovieByFilter(@RequestBody MovieFilterRequestDto dto){
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getMovieByFilter(dto))
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
	
	
	
}