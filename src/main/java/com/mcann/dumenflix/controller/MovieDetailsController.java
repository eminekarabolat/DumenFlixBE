package com.mcann.dumenflix.controller;

import com.mcann.dumenflix.dto.response.BaseResponse;
import com.mcann.dumenflix.entity.MovieDetails;
import com.mcann.dumenflix.service.MovieDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mcann.dumenflix.constant.RestApis.*;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(MOVIE_DETAILS)
public class MovieDetailsController {
	private final MovieDetailsService movieDetailsService;
	
	@GetMapping(GET_MOVIE_DETAILS)
	public ResponseEntity<BaseResponse<MovieDetails>> findById(Long id){
		return ResponseEntity.ok(BaseResponse.<MovieDetails>builder()
				                         .code(200)
				                         .message("film detaylari basariyla getirildi")
				                         .success(true)
				                             .data(movieDetailsService.findById(id))
		                                     .build());
	}
}