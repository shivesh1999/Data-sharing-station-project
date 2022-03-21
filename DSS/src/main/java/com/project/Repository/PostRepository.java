package com.project.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.project.Entity.Post;
import com.project.Entity.User;

import java.util.ArrayList;

@Repository
@EnableMongoRepositories
public interface PostRepository extends MongoRepository<Post, Long>{
    ArrayList<Post> findAllByUserId(Long id);
}
