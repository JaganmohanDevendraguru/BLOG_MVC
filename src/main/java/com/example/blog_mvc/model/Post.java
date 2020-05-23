package com.example.blog_mvc.model;

import java.sql.Blob;
import java.util.Date;

public class Post {

	private int postId;
	private int userId;
	private String postTitle;
	private Blob post;
	private Date postDate;
	private Date lastUpdateTime;
	private String status;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(int postId, String postTitle, Blob post, Date postDate, Date lastUpdateTime, String status) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.post = post;
		this.postDate = postDate;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
	}

	public Post(int postId, int userId, String postTitle, Blob post, Date postDate, Date lastUpdateTime,
			String status) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.post = post;
		this.postDate = postDate;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
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
	public Blob getPost() {
		return post;
	}
	public void setPost(Blob post) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", postTitle=" + postTitle 
				+ ", postDate=" + postDate + ", lastUpdateTime=" + lastUpdateTime + ", status=" + status + "]";
	}
	
}
