package com.mcann.dumenflix.config;


import com.mcann.dumenflix.entity.User;
import com.mcann.dumenflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {
	private final UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
	
	public UserDetails getUserById(Long userId) {
		Optional<User> optUser = userService.findById(userId);
		if (optUser.isEmpty()) {
			return null;
		}
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		
		return org.springframework.security.core.userdetails.User.builder()
				.username(optUser.get().getUsername())
				.password(optUser.get().getPassword())
				.accountExpired(false)
				.accountLocked(false)
				.authorities(authorities)
		        .build();
	}
}