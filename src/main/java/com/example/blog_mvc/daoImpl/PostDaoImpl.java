package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.blog_mvc.dao.PostDao;
import com.example.blog_mvc.model.Post;

@Repository
public class PostDaoImpl implements PostDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PostDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Post> findAll() {
		String sql = "select * from post";
		return jdbcTemplate.query(sql, new PostRowMapper());
	}

	@Override
	public List<Post> findAll(String status) {
		String sqlStatus = "select * from post where status=?";
		return jdbcTemplate.query(sqlStatus, new PostRowMapper(), status);
	}

	@Override
	public List<Post> findAllByDateAndStatus(String status, Date date) {
		String select = "select * from post where status=? and post_date=? order by post_date desc";
		return jdbcTemplate.query(select, new PostRowMapper(),status, date);
	}

	@Override
	public int updatePost(Post post) {
		String update = "update post set title=?, post=?, post_date=?, last_update_time=?, status=?"
				+ "where post_id=? and user_id=?";
		return jdbcTemplate.update(update, post.getPostTitle(), post.getPost(), post.getPostDate(), post.getLastUpdateTime(),
				post.getStatus(), post.getPostId(), post.getUserId());
	}

	@Override
	public int savePost(Post post) {
		String insert = "insert into post (user_id, post_id, title, post, post_date, last_update_time, status) "
				+ "values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(insert, post.getUserId(), post.getPostId(), post.getPostTitle(), post.getPost(), 
				post.getPostDate(), post.getLastUpdateTime(), post.getStatus());
	}

	@Override
	public int deletePost(int postId, int userId, Timestamp time) {
		String delete = "update post set status=?, last_update_time=? where post_id=? and user_id=?";
		return jdbcTemplate.update(delete, "N", time, postId, userId);
	}

	@Override
	public Post findPostById(int id) {
		String selectById = "select * from post where user_id=? order by post_date desc";
		return jdbcTemplate.queryForObject(selectById, new PostRowMapper());
	}

	@Override
	public List<Post> findAllByUser(int id) {
		String selectByUser = "select * from post where user_id=? order by post_date desc";
		return jdbcTemplate.query(selectByUser, new PostRowMapper(), id);
	}

}

class PostRowMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Post post = new Post();
		post.setUserId(rs.getInt(1));
		post.setPostId(rs.getInt(2));
		post.setPostTitle(rs.getString(3));
		post.setPost(rs.getBlob(4));
		post.setPostDate(rs.getTimestamp(5));
		post.setLastUpdateTime(rs.getTimestamp(6));
		post.setStatus(rs.getString(7));
		return post;
	}
	
}