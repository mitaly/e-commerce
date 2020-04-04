package com.services.ecommerce.service;

import org.springframework.stereotype.Service;

import com.services.ecommerce.entity.User;
import com.services.ecommerce.repository.UserRepository;

@Service
public class UserService {
	private UserRepository repo;
	
	public UserService(UserRepository userRepository) {
		this.repo = userRepository;
	}
	
	public User create(User user) {
		return repo.save(user);
	}
}
