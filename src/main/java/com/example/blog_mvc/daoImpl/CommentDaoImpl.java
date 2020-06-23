package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.blog_mvc.dao.CommentDao;
import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.CommentDetails;

@Repository
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
	public int saveComment(Comment comment) {
		String insert = "insert into comment (user_id, post_id, comment_id, comment_title, comment, "
				+ "comment_date, last_update_time, status) values (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(insert, comment.getUserId(), comment.getPostId(),comment.getCommentId(), comment.getCommentTitle(), comment.getComment(), comment.getCommentDate(),
				comment.getLastUpdateTime(), comment.getStatus());
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
	public List<Comment> findAllByPost(int id) {
			String selectCom = "select * from comment where post_id=? order by comment_date desc";
			return jdbcTemplate.query(selectCom, new CommentRowMapper(), id);
	}
	
	@Override
	public List<CommentDetails> findAllDetails() {
		String details = "select c.user_id, u.user_name, c.comment_id, c.title, c.comment, c.post_date from comment c,"
				+ "user u where c.user_id=u.user_id order by c.comment_date desc";
		return jdbcTemplate.query(details, new CommentDetailsRowMapper());
	}
	
	@Override
	public List<CommentDetails> singlePostCommentDetails(int pid) {
		String selectByPost = "select c.user_id, u.user_name, c.comment_id, c.comment_title, c.comment, c.comment_date from comment c,"
				+ "user u, post p where c.post_id=p.post_id and c.user_id=u.user_id and p.post_id=?";
		return jdbcTemplate.query(selectByPost, new CommentDetailsRowMapper(), pid);
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
		comment.setComment(rs.getBytes(5));
		comment.setCommentDate(rs.getTimestamp(6));
		comment.setLastUpdateTime(rs.getTimestamp(7));
		comment.setStatus(rs.getString(8));
		return comment;
	}
	
}

class CommentDetailsRowMapper implements RowMapper<CommentDetails> {
	@Override
	public CommentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		CommentDetails cd = new CommentDetails();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cd.setUserId(rs.getInt(1));
		cd.setUserName(rs.getString(2));
		cd.setCommentId(rs.getInt(3));
		cd.setCommentTitle(rs.getString(4));
		cd.setCommentContent(new String(Base64.getDecoder().decode(rs.getBytes(5))));
		try {
			cd.setCommentedDate(sf.parse(rs.getTimestamp(6).toString()));
		} catch (ParseException | SQLException e) {
			e.printStackTrace();
		}
		return cd;
	}

}