package com.example.blog_mvc.model;

import java.util.Comparator;
import java.util.Date;

public class PostDetails {

	private int userId;
	private String userName;
	private int postId;
	private String postTitle;
	private String postContent;
	private Date postDate;
	
	public PostDetails() {
		super();
	}

	public PostDetails(int userId, String userName, int postId, String postTitle, String postContent, Date postDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "PostDetails [userId=" + userId + ", userName=" + userName + ", postId=" + postId + ", postTitle="
				+ postTitle + ", postContent=" + postContent + ", postDate=" + postDate + "]";
	}
}

class PostDetailsDateDescOrder implements Comparator<PostDetails>{

	@Override
	public int compare(PostDetails o1, PostDetails o2) {
		return o2.getPostDate().compareTo(o1.getPostDate());
	}

	
}