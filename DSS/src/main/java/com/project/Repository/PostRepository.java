package com.project.Repository;

import java.util.List;

import com.project.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {

	 @Query(value = "SELECT * FROM Posts u WHERE u.post_type = ?1", nativeQuery = true)
	List<Post> findByPostType(String string);
	
}
