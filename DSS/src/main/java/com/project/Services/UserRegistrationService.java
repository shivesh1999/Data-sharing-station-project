package com.project.Services;

import com.project.Entity.User;
import com.project.Repository.UserRepository;
import com.project.UserRegistration.UserRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

	@Autowired
    UserRepository userRepository;
	
	@Autowired
    SequenceGeneratorService sequenceGenerator;

    public void register(User user) {
        userRepository.save(user);
    }
}
