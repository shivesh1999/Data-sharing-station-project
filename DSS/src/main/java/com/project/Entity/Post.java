package com.project.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Entity
@Document("Posts")
public class Post {
	
	@Transient
	public static final String SEQUENCE_NAME = "posts_sequence";

	@Id
	private Long id;

	private Long userId;
	@Field
	private String Description;
	private String postedBy;
	private LocalDateTime time;
	private Binary File;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Binary getFile() {
		return File;
	}
	public void setFile(Binary file) {
		File = file;
	}

	public Post(Long id, Long userId, String description, String postedBy, LocalDateTime time, Binary file) {
		super();
		this.id = id;
		this.userId = userId;
		Description = description;
		this.postedBy = postedBy;
		this.time = time;
		File = file;
	}	
}
