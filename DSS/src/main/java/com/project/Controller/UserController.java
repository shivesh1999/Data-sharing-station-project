package com.project.Controller;

import java.util.ArrayList;
import java.util.List;

import com.project.Entity.Post;
import com.project.Repository.PostRepository;
import com.project.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.project.Entity.User;
import com.project.Services.CommonService;

@Controller
public class UserController {
	
	@Autowired
	private CommonService userService;
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private PostService postService;
	
	@PostMapping("/feeds")
	public String getFeedsPage(@RequestParam("email") String email,
							   @RequestParam("password") String password,
							   ModelMap model,
							   ModelMap allPosts,
							   ModelMap unsubscribedResources,
							   ModelMap subscribedResources,
							   ModelMap msg)
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
			Iterable<User> subscribedResourcesDetails=userService.getSubscribedResourcesDetails(user);
			subscribedResources.addAttribute("subscribedResources", subscribedResourcesDetails);
			List<User> Resources=userService.getTopResources();
			unsubscribedResources.addAttribute("unsubscribedResources", Resources);
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
	@GetMapping("/feeds/{email}")
	public String getFeeds(@PathVariable("email") String email,
							   ModelMap model,
							   ModelMap allPosts,
						   ModelMap unsubscribedResources)
	{
		User user = userService.getUser(email);
		model.addAttribute("user",user);
		List<User> Resources=userService.getTopResources();
		unsubscribedResources.addAttribute("unsubscribedResources", Resources);
		List<Post> posts=postRepo.findAll();
		allPosts.addAttribute("posts", posts);
		return "feeds";
	}

	@GetMapping("/profile/{email}")
	public String getFeedsPage(@PathVariable("email") String email,
							   ModelMap model,
							   ModelMap allPosts,
							   ModelMap msg)
	{
		User user = userService.getUser(email);
		model.addAttribute("user",user);
		ArrayList<Post> posts=postService.getPosts(user.getId());
		if(posts.size()>0){
		allPosts.addAttribute("posts", posts);
		return "profile";
		}
		else{
			model.addAttribute("msg","You have no posts yet.");
			return "profile";
		}
	}

	@GetMapping("/profile-view/{email}")
	public String getViewProfilePage(@PathVariable("email") String email,
							   ModelMap model,
							   ModelMap allPosts,
							   ModelMap msg)
	{
		User user = userService.getUser(email);
		model.addAttribute("user",user);
		ArrayList<Post> posts=postService.getPosts(user.getId());
		if(posts.size()>0){
			allPosts.addAttribute("posts", posts);
			return "viewProfile";
		}
		else{
			model.addAttribute("msg","You have no posts yet.");
			return "viewProfile";
		}
	}


}
