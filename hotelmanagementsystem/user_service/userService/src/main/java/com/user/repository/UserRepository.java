package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	ResponseEntity<User> findByUserId(String userId);
	
}
