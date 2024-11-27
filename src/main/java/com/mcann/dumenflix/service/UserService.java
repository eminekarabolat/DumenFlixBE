package com.mcann.dumenflix.service;

import com.mcann.dumenflix.dto.request.LoginRequestDto;
import com.mcann.dumenflix.dto.request.RegisterRequestDto;
import com.mcann.dumenflix.entity.User;
import com.mcann.dumenflix.exception.DumenFlixApplicationException;
import com.mcann.dumenflix.exception.ErrorType;
import com.mcann.dumenflix.mapper.UserMapper;
import com.mcann.dumenflix.repository.UserRepository;
import com.mcann.dumenflix.utility.JwtManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final JwtManager jwtManager;
	public void register(RegisterRequestDto dto) {
		
		User user = UserMapper.INSTANCE.fromRegisterRequestDto(dto);
		userRepository.save(user);
	}
	
	public Optional<User> findById(Long userId) {
	 return userRepository.findById(userId);
	}
	
	public String doLogin( LoginRequestDto dto) {
		Optional<User> optUser =
				userRepository.findOptionalByUsernameAndPassword(dto.username(), dto.password());
		if (optUser.isEmpty()){
			throw new DumenFlixApplicationException(ErrorType.INVALID_USERNAME_OR_PASSWORD);
		}
		String token = jwtManager.createToken(optUser.get().getId());
		return token;
	}
	
	public User getProfile(String token) {
		Optional<Long> optUserId = jwtManager.validateToken(token);
		if (optUserId.isEmpty()) {
			throw new DumenFlixApplicationException(ErrorType.INVALID_TOKEN);
		}
		Optional<User> optUser = userRepository.findById(optUserId.get());
		if (optUser.isEmpty()) {
			throw new DumenFlixApplicationException(ErrorType.NOT_FOUND_USER);
		}
		return optUser.get();
	}
}