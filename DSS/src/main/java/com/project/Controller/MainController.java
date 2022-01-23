package com.project.Controller;

import java.util.List;

import com.project.Entity.Post;
import com.project.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
    PostRepository postRepo;
	
	@RequestMapping("")
	public String viewHomePage(ModelMap allPosts) {
		List<Post> posts =postRepo.findByPostType("PUBLIC");
		allPosts.addAttribute("posts",posts);
		return "index";
	}
	
	@RequestMapping("/registerUser")
	public String viewRegistrationPage()
	{
		return "register";
	}
	
	@RequestMapping("/loginPage")
	public String getLoginPage()
	{
		return "login";
	}
}
