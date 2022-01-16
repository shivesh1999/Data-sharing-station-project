package com.project;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class PostController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository repo;
	
	@RequestMapping("/createPost/{currentUser}")
	public String showCreatePostPage(@PathVariable("currentUser") int currerntUserId, ModelMap modelMap) {
		modelMap.addAttribute("currentUser", currerntUserId);
		return "createPost";
	}
	@RequestMapping(value = "/createPost/upload/{currentUser}", method = RequestMethod.POST)
	public String createPost(@RequestParam("preview") MultipartFile multiPartFile1,@RequestParam("pdf") MultipartFile multiPartFile2, @RequestParam("postTopic") String PostTopic, @PathVariable("currentUser") int currentUserId,@RequestParam("postType") String PostType, ModelMap allPosts,ModelMap currentUser)
	{
		Post post=new Post();
		post.setPostTopic(PostTopic);
		post.setPostType(PostType);
		try {
			post.setPreview(multiPartFile1.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			post.setPdf(multiPartFile2.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user= userRepo.findById(currentUserId).get();
		post.setUserId(currentUserId);
		post.setUserName(user.getUserName());
		repo.save(post);
		currentUser.addAttribute("currentUser",user);
		List<Post> posts =repo.findByPostType("PUBLIC");
		allPosts.addAttribute("posts",posts);
		return "feeds";
	}
	@RequestMapping("/download/{postId}")
	public StreamingResponseBody download(@PathVariable("postId") int id, HttpServletResponse response)
	{
		Post post=repo.getById(id);
		byte[] data = post.getPdf();
		response.setHeader("Content-Disposition","attachment;filename=file.pdf");
		return OutputStream->{ OutputStream.write(data);};
	}
	@RequestMapping("/downloadPreview/{postId}")
	public StreamingResponseBody downloadPreview(@PathVariable("postId") int id, HttpServletResponse response)
	{
		Post post=repo.getById(id);
		byte[] data = post.getPreview();
		response.setHeader("Content-Disposition","attachment;filename=preview.jpeg");
		return OutputStream->{ OutputStream.write(data);};
	}
}
