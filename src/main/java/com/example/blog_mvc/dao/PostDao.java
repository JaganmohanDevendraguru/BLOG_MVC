package com.example.blog_mvc.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.blog_mvc.model.Post;

@Repository
public interface PostDao {

	public abstract List<Post> findAll();
	public abstract List<Post> findAll(String status);
	public abstract List<Post> findAllByDateAndStatus(String status, Date date);
	public abstract int updatePost(Post post);
	public abstract int savePost(Post post);
	public abstract int deletePost(int postId, int userId, Timestamp time);
	public abstract Post findPostById(int id);
	public abstract List<Post> findAllByUser(int id);
}
