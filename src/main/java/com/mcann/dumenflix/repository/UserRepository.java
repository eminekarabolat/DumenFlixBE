package com.mcann.dumenflix.repository;

import com.mcann.dumenflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOptionalByUsernameAndPassword(String username,String password);
}