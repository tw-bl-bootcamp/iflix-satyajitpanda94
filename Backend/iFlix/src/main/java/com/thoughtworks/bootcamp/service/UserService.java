package com.thoughtworks.bootcamp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thoughtworks.bootcamp.dto.LoginDTO;
import com.thoughtworks.bootcamp.model.RegisteredUser;
import com.thoughtworks.bootcamp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	public String login(LoginDTO dto) {
		Optional<RegisteredUser> user=userRepository.findByEmail(dto.getEmail());
		if(user.isPresent() && passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
			return "Login Successful";
		return "Login Unsuccessful";
	}
}
