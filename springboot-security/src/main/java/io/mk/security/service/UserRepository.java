package io.mk.security.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByUsername(String username);
}
