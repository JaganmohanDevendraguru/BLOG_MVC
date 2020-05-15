package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.blog_mvc.dao.CommentDao;
import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.Post;

public class CommentDaoImpl implements CommentDao{

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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
			String selectCom = "select * from comment where post_id=? order by comment_date desc";
			return jdbcTemplate.query(selectCom, new CommentRowMapper(), id);
	}

}

class CommentRowMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}