package com.project.Controller;


import com.project.Repository.UserRepository;
import com.project.Services.SequenceGeneratorService;
import com.project.Services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    @Autowired
    private UserRegistrationService registrationService;

    @GetMapping("")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/signup")
    public String getSignUpPage(){ return "signup";}

    @GetMapping("/login")
    public String getLogInPage(){ return "login";}

    



}
