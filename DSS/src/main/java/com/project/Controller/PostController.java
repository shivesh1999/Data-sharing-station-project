package com.project.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import com.project.Entity.Post;
import com.project.Repository.PostRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.Entity.User;
import com.project.Repository.UserRepository;
import com.project.Services.CommonService;
import com.project.Services.PostService;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class PostController {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private CommonService commonService;
	@Autowired
	private PostService postService;

	
	
	@PostMapping("/createPost/{userEmail}")
	public String createPost(@RequestParam("Description") String Description,
							 @RequestParam("File") MultipartFile File,
							 @ModelAttribute String email,
							 @PathVariable("userEmail") String id,
							 ModelMap allPosts,ModelMap msg)
	{

		User user=commonService.getUser(id);
		List<Post> posts =postRepo.findAll();
		System.out.println(posts);
		if(posts.size()>0) {
			allPosts.addAttribute("posts", posts);
		}
		else{
			msg.addAttribute("msg","No posts yet.");
		}
		try {
			postService.createPost(user,Description,File);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in post Service : "+e);
		}
		return "feeds";
	}

	@RequestMapping("/download/{postId}")
	public StreamingResponseBody download(@PathVariable("postId") int id, HttpServletResponse response)
	{
		Optional<Post> post=postRepo.findById(Long.valueOf(id));
		Binary data = post.get().getFile();
		response.setHeader("Content-Disposition","attachment;filename=file.pdf");
		return OutputStream->{ OutputStream.write(data.getData());};
	}

	@GetMapping("/delete/{userEmail}/{postId}")
	public String createPost(
							 @PathVariable("userEmail") String id,
							 @PathVariable("postId") long postId,
							 ModelMap allPosts,
							 ModelMap model,
							 ModelMap msg)
	{

		User user=commonService.getUser(id);
		model.addAttribute("user",user);
		List<Post> posts =postService.getPosts(user.getId());
		allPosts.addAttribute("posts", posts);
		msg.addAttribute("msg","Post deleted successfully");
		postRepo.deleteById(postId);
		return "profile";
	}

}
