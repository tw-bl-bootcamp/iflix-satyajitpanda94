package com.thoughtworks.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.bootcamp.dto.LoginDTO;
import com.thoughtworks.bootcamp.service.UserService;

@RestController
@RequestMapping("/iFlix")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDTO dto ) {
		return userService.login(dto);
	}
}
