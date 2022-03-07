package com.project.Controller;

import com.project.Entity.User;
import com.project.Services.SequenceGeneratorService;
import com.project.Services.UserRegistrationService;
import com.project.UserRegistration.UserRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
	
	@Autowired
    private UserRegistrationService registrationService;
	
	@Autowired
    SequenceGeneratorService sequenceGenerator;

	  @GetMapping(value= "/register")
	  public String registerUser(UserRegistrationRequest request) {
		  User user=new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),
				  request.getFirstname(),
				  request.getLastname(),
				  request.getEmail(),
				  request.getContact(),
				  request.getPassword());
	      registrationService.register(user);
	      return "login";
	  }

}
