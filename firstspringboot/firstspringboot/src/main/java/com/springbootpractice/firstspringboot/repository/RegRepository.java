package com.springbootpractice.firstspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootpractice.firstspringboot.models.Reg;

public interface RegRepository extends JpaRepository<Reg, Long> {
	//Optional<Reg> findByUsernameAndPassword(String username, String password);
	Optional<Reg> findByUsername(String username);
}
