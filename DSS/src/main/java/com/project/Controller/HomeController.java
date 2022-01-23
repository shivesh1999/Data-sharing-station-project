package com.project.Controller;

import com.project.Entity.User;
import com.project.Entity.UserRole;
import com.project.Repository.UserRepository;
import com.project.Services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public String getHomePage(){
        userRepo.save(new User(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME),"shivesh","safal","shiveshsafal102@gmail.com","7761897475","password"));

        return "Hi";
    }
}
