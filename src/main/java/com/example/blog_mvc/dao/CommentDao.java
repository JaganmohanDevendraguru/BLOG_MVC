package com.example.blog_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.blog_mvc.model.Comment;

@Repository
public interface CommentDao {

	public abstract List<Comment> findAll();
	public abstract List<Comment> findAll(String status);
	public abstract int updateComment(Comment comment);
	public abstract int deleteComment(int id);
	public abstract Comment findByCommentId(int id);
	public abstract List<Comment> findAllByPost(int id);
}