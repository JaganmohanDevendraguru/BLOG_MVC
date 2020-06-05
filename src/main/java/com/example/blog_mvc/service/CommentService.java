package com.example.blog_mvc.service;

import java.util.Date;
import java.util.List;

import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.CommentDetails;

public interface CommentService {
	
	public abstract List<Comment> findAll();
	public abstract List<Comment> findAll(String status);
	public abstract List<Comment> findAllByDateAndStatus(String status, Date date);
	public abstract int updateComment(Comment comment);
	public abstract int saveComment(Comment comment);
	public abstract int deleteComment(int id);
	public abstract Comment findByCommentId(int id);
	public abstract List<Comment> findAllByPost(int postId);
	public abstract List<CommentDetails> singlePostCommentDetails(int postId);
}
