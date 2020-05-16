package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		String all = "select * from comment";
		return jdbcTemplate.query(all, new CommentRowMapper());
	}

	@Override
	public List<Comment> findAll(String status) {
		String select = "select * from comment where status=?";
		return jdbcTemplate.query(select, new CommentRowMapper(), status);
	}

	@Override
	public int updateComment(Comment comment) {
		String update = "update comment set comment_title=?, comment=?, comment_date=?,"
				+ "last_update_time=?, status=? where comment_id=?";
		return jdbcTemplate.update(update, comment.getCommentTitle(), comment.getComment(), comment.getCommentDate(),
				comment.getLastUpdateTime(), comment.getStatus(), comment.getCommentId());
	}

	@Override
	public int deleteComment(int id) {
		String delete = "update comment set status=? where comment_id=?";
		return jdbcTemplate.update(delete, "N", id);
	}

	@Override
	public Comment findByCommentId(int id) {
		String select = "select * from comment where comment_id=?";
		return jdbcTemplate.queryForObject(select, new CommentRowMapper(), id);
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
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt(3));
		comment.setPostId(rs.getInt(2));
		comment.setUserId(rs.getInt(1));
		comment.setCommentTitle(rs.getString(4));
		comment.setComment(rs.getBlob(5));
		comment.setCommentDate(rs.getTimestamp(6));
		comment.setLastUpdateTime(rs.getTimestamp(7));
		comment.setStatus(rs.getString(8));
		return comment;
	}
	
}