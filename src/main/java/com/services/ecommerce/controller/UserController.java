package com.services.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.ecommerce.entity.User;
import com.services.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService service;
	
	public UserController(UserService userService) {
		this.service = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
}
