package com.thoughtworks.bootcamp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thoughtworks.bootcamp.dto.LoginDTO;
import com.thoughtworks.bootcamp.model.RegisteredUser;
import com.thoughtworks.bootcamp.repository.UserRepository;
import com.thoughtworks.bootcamp.response.Response;

@Service
public class UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	public Response login(LoginDTO dto) {
		System.out.println(dto.toString());
		Optional<RegisteredUser> user=userRepository.findByEmail(dto.getEmail());
		if(user.isPresent() && passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
			return new Response("Login Successful",200);
		return new Response("Login Unsuccessful",400);
	}
}
