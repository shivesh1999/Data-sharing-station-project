package com.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
	@Column(name = "post_topic")
	private String postTopic;
	
	@Lob
	@Column(name="preview")
	private byte[] preview;
	
	@Lob
	@Column(name="pdf")
	private byte[] pdf;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="post_type")
	private String postType;
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPostType() {
		return postType;
	}


	public void setPostType(String postType2) {
		this.postType = postType2;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getPostTopic() {
		return postTopic;
	}


	public void setPostTopic(String postTopic) {
		this.postTopic = postTopic;
	}


	public byte[] getPreview() {
		return preview;
	}


	public void setPreview(byte[] preview) {
		this.preview = preview;
	}


	public byte[] getPdf() {
		return pdf;
	}


	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
}
