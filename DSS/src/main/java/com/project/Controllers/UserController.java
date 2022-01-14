package com.project.Controllers;

import java.util.List;

import com.project.*;
import com.project.Entity.Post;
import com.project.Entity.User;
import com.project.Repository.PostRepository;
import com.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
    UserServices service;
	@Autowired
	UserRepository repo;
	@Autowired
	PostRepository postRepo;
	
	@GetMapping("/profile/{currentUser}")
	public String viewProfile(@PathVariable("currentUser") int currentUserId,ModelMap currentUser)
	{
		User current=repo.findById(currentUserId).get();
		currentUser.addAttribute("currentUser", current);
		return "profile";
	}
	
	@GetMapping("/delete/{currentUser}")
	public String deleteUser(@PathVariable("currentUser") int currentUserId)
	{
		repo.deleteById(currentUserId);
		return "index";
	}
	
	@PostMapping("/addUser")
	public String viewUserLoginPage(@ModelAttribute("User") User user,ModelMap modelmap) {
		User userSaved = service.AddUser(user);
		String msg=userSaved.getUserName()+" Congratulations! Welcome to the Club !!";
		modelmap.addAttribute("msg",msg);
		return "register";
	}
	
	@RequestMapping(value="/feeds",method = RequestMethod.POST)
	public String loginUser(@RequestParam("userEmail") String email,@RequestParam("password") String password, ModelMap modelmap,ModelMap currentUser,ModelMap allPosts)
	{
		User user=repo.findByUserEmail(email);
		if(user==null)
		{
			modelmap.addAttribute("msg","Invalid Email or Password !");
			return "login";
		}
		if(user.getPassword().equals(password)){
			modelmap.addAttribute("currentUser",user);
			List<Post> posts =postRepo.findAll();
			allPosts.addAttribute("posts",posts);
			return "feeds";
		}
		else
		{
			modelmap.addAttribute("msg","Invalid Email or Password !");
			return "login";
		}
	}
}
