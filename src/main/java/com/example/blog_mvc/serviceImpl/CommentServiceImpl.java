package com.example.blog_mvc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAll(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAllByDateAndStatus(String status, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment findByCommentId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAllByPost(Post id) {
		// TODO Auto-generated method stub
		return null;
	}

}
