package com.example.blog_mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8063952288669900365L;
	private int commentId;
	private int postId;
	private int userId;
	@NotEmpty(message="Please enter the title of the comment!")
	private String commentTitle;
	@NotEmpty(message="Comment cannot be empty")
	private byte[] comment;
	private Date commentDate;
	private Date lastUpdateTime;
	private String status;
	
	public Comment() {
		super();
	}
	
	public Comment(int commentId, String commentTitle, byte[] comment, Date commentDate, Date lastUpdateTime,
			String status) {
		super();
		this.commentId = commentId;
		this.commentTitle = commentTitle;
		this.comment = comment;
		this.commentDate = commentDate;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
	}
	
	public Comment(int commentId, int postId, int userId, String commentTitle, byte[] comment, Date commentDate,
			Date lastUpdateTime, String status) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.userId = userId;
		this.commentTitle = commentTitle;
		this.comment = comment;
		this.commentDate = commentDate;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public byte[] getComment() {
		return comment;
	}
	public void setComment(byte[] comment) {
		this.comment = comment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
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
		return "Comment [commentId=" + commentId + ", postId=" + postId + ", userId=" + userId + ", commentTitle="
				+ commentTitle + ", comment=" + comment + ", commentDate=" + commentDate + ", lastUpdateTime="
				+ lastUpdateTime + ", status=" + status + ", getCommentId()=" + getCommentId() + ", getPostId()="
				+ getPostId() + ", getUserId()=" + getUserId() + ", getCommentTitle()=" + getCommentTitle()
				+ ", getComment()=" + getComment() + ", getCommentDate()=" + getCommentDate() + ", getLastUpdateTime()="
				+ getLastUpdateTime() + ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
