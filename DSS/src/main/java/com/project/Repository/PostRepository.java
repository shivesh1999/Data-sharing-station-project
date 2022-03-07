package com.project.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.project.Entity.Post;
import com.project.Entity.User;

@Repository
@EnableMongoRepositories
public interface PostRepository extends MongoRepository<Post, Long>{

}
