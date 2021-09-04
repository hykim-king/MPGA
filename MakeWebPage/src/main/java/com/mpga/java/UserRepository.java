package com.mpga.java;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
}
