package com.project.Controller;

import java.util.List;
import java.util.Optional;

import com.project.Entity.Post;
import com.project.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Entity.User;
import com.project.Services.CommonService;
import com.project.Services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private CommonService userService;
	@Autowired
	private PostRepository postRepo;
	
	@PostMapping("/feeds")
	public String getFeedsPage(@RequestParam("email") String email,
							   @RequestParam("password") String password,
							   ModelMap model,ModelMap allPosts,ModelMap msg)
	{
		User user = userService.getUser(email);
		if(user==null)
		{
			model.addAttribute("msg","Invalid username or password");
			return "login";
		}
		else
		{
		if((user.getPassword()).equals(password)){
			List<Post> posts =postRepo.findAll();
			System.out.println(posts);
			if(posts.size()>0) {
				allPosts.addAttribute("posts", posts);
			}
			else{
				msg.addAttribute("msg","No posts yet.");
			}
			model.addAttribute("user",user);
			return "feeds";
		}
		else {
			model.addAttribute("msg","Invalid username or password");
			return "login";
		}
		}
	}

}
