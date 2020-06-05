package com.example.blog_mvc.model;

import java.util.Date;

public class CommentDetails {

	private int userId;
	private String userName;
	private int commentId;
	private String commentTitle;
	private String commentContent;
	private Date commentedDate;

	public CommentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDetails(int userId, String userName, int commentId, String commentTitle, String commentContent,
			Date commentedDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.commentId = commentId;
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
		this.commentedDate = commentedDate;
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentTitle() {
		return commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}

	@Override
	public String toString() {
		return "CommentDetails [userId=" + userId + ", userName=" + userName + ", commentId=" + commentId
				+ ", commentTitle=" + commentTitle + ", commentContent=" + commentContent + ", commentedDate="
				+ commentedDate + "]";
	}
}
