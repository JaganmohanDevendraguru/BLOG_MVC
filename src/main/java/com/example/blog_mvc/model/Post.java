package com.example.blog_mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4200646718179635618L;
	/**
	 * 
	 */
	private int postId;
	private int userId;
	@NotEmpty(message = "Post title cannot be empty")
	private String postTitle;
	@NotEmpty(message = "Post cannot be empty")
	private byte[] post;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date postDate;
	private Date lastUpdateTime;
	@NotEmpty(message = "Please select the valid status")
	private String postStatus;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(int postId, String postTitle, byte[] post, Date postDate, Date lastUpdateTime, String postStatus) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.post = post;
		this.postDate = postDate;
		this.lastUpdateTime = lastUpdateTime;
		this.postStatus = postStatus;
	}

	public Post(int postId, int userId, String postTitle, byte[] post, Date postDate, Date lastUpdateTime,
			String postStatus) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.post = post;
		this.postDate = postDate;
		this.lastUpdateTime = lastUpdateTime;
		this.postStatus = postStatus;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public byte[] getPost() {
		return post;
	}
	public void setPost(byte[] post) {
		this.post = post;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", postTitle=" + postTitle 
				+ ", postDate=" + postDate + ", lastUpdateTime=" + lastUpdateTime + ", status=" + postStatus + "]";
	}
	
}
