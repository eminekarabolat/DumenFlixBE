package com.mcann.dumenflix.controller;


import com.mcann.dumenflix.dto.request.LoginRequestDto;
import com.mcann.dumenflix.dto.request.RegisterRequestDto;
import com.mcann.dumenflix.dto.response.BaseResponse;
import com.mcann.dumenflix.entity.User;
import com.mcann.dumenflix.exception.DumenFlixApplicationException;
import com.mcann.dumenflix.exception.ErrorType;
import com.mcann.dumenflix.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mcann.dumenflix.constant.RestApis.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
	private final UserService userService;
	
	
	@PostMapping(REGISTER)
	public ResponseEntity<BaseResponse<Boolean>> register(@RequestBody @Valid RegisterRequestDto dto){
		if (!dto.password().equals(dto.rePassword())){
			throw new DumenFlixApplicationException(ErrorType.PASSWORD_ERROR);
		}
		userService.register(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .code(200)
				                         .success(true)
				                         .data(true)
				                         .message("Üyelik başarıyla oluşturuldu.")
		                                     .build());
	}
	
	@PostMapping(DOLOGIN)
	public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody @Valid LoginRequestDto dto){
		return ResponseEntity.ok(BaseResponse.<String>builder()
				                         .code(200)
				                         .success(true)
				                         .message("Giriş başarılı.")
				                         .data(userService.doLogin(dto))
		                                 .build());
	}
	
	@GetMapping(GETPROFILE)
	public ResponseEntity<BaseResponse<User>> getProfile(String token){
		return ResponseEntity.ok(BaseResponse.<User>builder()
				                         .code(200)
				                         .message("Profil getirildi.")
				                         .data(userService.getProfile(token))
				                         .success(true)
		                                     .build());
	}
	
}