package com.example.blog_mvc.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.PostDetails;

public interface PostService {

	public abstract List<Post> findAll();
	public abstract List<Post> findAll(String status);
	public abstract List<Post> findAllByDateAndStatus(String status, Date date);
	public abstract int updatePost(Post post);
	public abstract int savePost(Post post);
	public abstract int deletePost(int pId, int uId);
	public abstract Post findByPostById(int uid, int pid);
	public abstract Post findByPostById(int pid);
	public abstract List<Post> findAllByUser(int id);
	public List<Post> findAllByUser(int id, int limit);
	public abstract PostDetails singlePostDetails(int postId);
	public abstract List<PostDetails> fullPostDetails();
	public List<PostDetails> fullPostDetails(String status);
	public abstract void upload(MultipartFile file, String directory);
	public File[] showFiles(String directory);
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit);
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit, String status);
}
