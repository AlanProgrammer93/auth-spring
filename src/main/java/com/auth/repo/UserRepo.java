package com.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
}
