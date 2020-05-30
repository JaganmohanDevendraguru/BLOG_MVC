package com.example.blog_mvc.serviceImpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_mvc.dao.PostDao;
import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.util.PostStatus;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao dao;
	
	@Override
	public List<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Post> findAll(String status) {
		return dao.findAll(status);
	}

	@Override
	public List<Post> findAllByDateAndStatus(String status, Date date) {
		return dao.findAllByDateAndStatus(status, date);
	}

	@Override
	public int updatePost(Post post) {
		return dao.updatePost(post);
	}
	
	@Override
	public int savePost(Post post, String publishStatus) {
		Date date = Calendar.getInstance().getTime();
		post.setLastUpdateTime(date);
		post.setPostDate(date);
		String status = publishStatus.equals(PostStatus.PUBLISHED.getStatus()) ? "P" : "DR";
		post.setStatus(status);
		return dao.savePost(post);
	}

	@Override
	public int deletePost(int postId, int userId) {
		java.sql.Timestamp time = new Timestamp(Calendar.getInstance().getTimeInMillis());
		return dao.deletePost(postId, userId, time);
	}

	@Override
	public Post findByPostById(int uid, int pid) {
		return dao.findPostById(uid, pid);
	}

	@Override
	public Post findByPostById(int pid) {
		return dao.findPostById(pid);
	}

	@Override
	public List<Post> findAllByUser(int uid) {
		return dao.findAllByUser(uid);
	}

	@Override
	public List<Map<String, Object>> fullPostDetails(int postId) {
		return null;
	}

}
