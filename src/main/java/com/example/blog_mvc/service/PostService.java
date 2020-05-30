package com.example.blog_mvc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.blog_mvc.model.Post;

public interface PostService {

	public abstract List<Post> findAll();
	public abstract List<Post> findAll(String status);
	public abstract List<Post> findAllByDateAndStatus(String status, Date date);
	public abstract int updatePost(Post post);
	public abstract int savePost(Post post, String publishStatus);
	public abstract int deletePost(int pId, int uId);
	public abstract Post findByPostById(int uid, int pid);
	public abstract Post findByPostById(int pid);
	public abstract List<Post> findAllByUser(int id);
	public abstract List<Map<String, Object>> fullPostDetails(int postId);
}
