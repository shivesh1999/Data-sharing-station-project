package com.project.Services;

import java.util.ArrayList;
import java.util.List;

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


	public Iterable<User> getSubscribedResourcesDetails(User user) {
		ArrayList<Long> subscribedIds=user.getResources();
		Iterable<User> subscribedResourcesDetails=userRepository.findAllById(subscribedIds);
		return subscribedResourcesDetails;
	}

	public List<User> getTopResources() {
		// TODO: Add personalized recommendations
		List<User> resources=userRepository.findAll();
		return resources;
	}
}
