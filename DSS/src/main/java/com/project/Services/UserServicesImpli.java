package com.project.Services;

import com.project.Entity.User;
import com.project.Repository.UserRepository;
import com.project.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpli implements UserServices {

	@Autowired
	UserRepository repo;
	
	@Override
	public User AddUser(User user) {
		return repo.save(user);
	}

}
