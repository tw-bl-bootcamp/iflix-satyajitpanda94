package com.thoughtworks.bootcamp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtworks.bootcamp.model.RegisteredUser;

public interface UserRepository extends JpaRepository<RegisteredUser, Long>{

	Optional<RegisteredUser> findByEmail(String email);
}
