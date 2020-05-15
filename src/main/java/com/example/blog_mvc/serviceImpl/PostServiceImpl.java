package com.example.blog_mvc.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAll(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAllByDateAndStatus(String status, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePost(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Post findByPostById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAllByUser(Post id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> fullPostDetails(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
