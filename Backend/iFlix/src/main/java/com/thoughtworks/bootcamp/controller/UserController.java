package com.thoughtworks.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.bootcamp.dto.LoginDTO;
import com.thoughtworks.bootcamp.response.Response;
import com.thoughtworks.bootcamp.service.UserService;

@RestController
@RequestMapping("/iFlix")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestBody LoginDTO dto){
		Response response=userService.login(dto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
