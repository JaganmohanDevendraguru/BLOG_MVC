package com.example.blog_mvc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_mvc.dao.CommentDao;
import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.CommentDetails;
import com.example.blog_mvc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao dao;
	
	@Override
	public List<Comment> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Comment> findAll(String status) {
		return dao.findAll(status);
	}

	@Override
	public List<Comment> findAllByDateAndStatus(String status, Date date) {
		return null;
	}

	@Override
	public int updateComment(Comment comment) {
		return dao.updateComment(comment);
	}
	
	@Override
	public int saveComment(Comment comment) {
		Date now = new Date();
		comment.setCommentDate(now);
		comment.setLastUpdateTime(now);
		comment.setStatus("P");
		return dao.saveComment(comment);
	}

	@Override
	public int deleteComment(int id) {
		return dao.deleteComment(id);
	}

	@Override
	public Comment findByCommentId(int id) {
		return dao.findByCommentId(id);
	}

	@Override
	public List<Comment> findAllByPost(int id) {
		return dao.findAllByPost(id);
	}

	@Override
	public List<CommentDetails> singlePostCommentDetails(int postId) {
		return dao.singlePostCommentDetails(postId);
	}

}
