package com.project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Entity.User;
import com.project.Repository.UserRepository;

@Service
public class CommonService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUser(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		return user;
	}
	
	
}
