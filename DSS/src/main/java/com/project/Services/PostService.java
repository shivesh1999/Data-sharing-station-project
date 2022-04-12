package com.project.Services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.Entity.Post;
import com.project.Entity.User;
import com.project.Repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	private LocalDateTime time;
	
	public void createPost(User user, String description, MultipartFile file) throws IOException
	{
		byte[] fileInByte = file.getBytes();
		postRepository.save(new Post(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),user.getId(), description, user.getFirstname()+user.getLastname(), time.now(), new Binary(BsonBinarySubType.BINARY, fileInByte)));
	}

    public ArrayList<Post> getPosts(Long id) {
		ArrayList<Post> posts=postRepository.findAllByUserId(id);
		return posts;
    }
}
