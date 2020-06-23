package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.blog_mvc.dao.PostDao;
import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.PostDetails;

@Repository
public class PostDaoImpl implements PostDao {

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
		return jdbcTemplate.query(select, new PostRowMapper(), status, date);
	}

	@Override
	public int updatePost(Post post) {
		String update = "update post set title=?, post=?, post_date=?, last_update_time=?, status=?"
				+ "where post_id=? and user_id=?";
		return jdbcTemplate.update(update, post.getPostTitle(), post.getPost(), post.getPostDate(),
				post.getLastUpdateTime(), post.getPostStatus(), post.getPostId(), post.getUserId());
	}

	@Override
	public int savePost(Post post) {
		String insert = "insert into post (user_id, post_id, title, post, post_date, last_update_time, status) "
				+ "values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(insert, post.getUserId(), post.getPostId(), post.getPostTitle(), post.getPost(),
				post.getPostDate(), post.getLastUpdateTime(), post.getPostStatus());
	}

	@Override
	public int deletePost(int postId, int userId, Timestamp time) {
		String delete = "update post set status=?, last_update_time=? where post_id=? and user_id=?";
		return jdbcTemplate.update(delete, "N", time, postId, userId);
	}

	@Override
	public Post findPostById(int uid, int pid) {
		String selectById = "select * from post where user_id=? and post_id=? order by post_date desc";
		return jdbcTemplate.queryForObject(selectById, new PostRowMapper(), uid, pid);
	}

	@Override
	public Post findPostById(int pid) {
		String selectById = "select * from post where post_id=? order by post_date desc";
		return jdbcTemplate.queryForObject(selectById, new PostRowMapper(), pid);
	}

	@Override
	public List<Post> findAllByUser(int id) {
		return findAllByUser(id, 0);
	}

	@Override
	public List<PostDetails> findAllDetails() {
		return findAllDetails(null);
	}
	
	@Override
	public List<PostDetails> findAllDetails(String status) {
		StringBuilder details = new StringBuilder("select p.user_id, u.user_name, p.post_id, p.title, p.post, p.post_date from post p,"
				+ "user u where p.user_id=u.user_id");
		if(status != null) {
			details.append(" and p.status=? order by p.post_date desc");
			return jdbcTemplate.query(details.toString(), new PostDetailsRowMapper(), status);
		}
			
		details.append("  order by p.post_date desc");
		return jdbcTemplate.query(details.toString(), new PostDetailsRowMapper());
	}
	
	@Override
	public PostDetails singlePostDetails(int pid) {
		String selectByPost = "select p.user_id, u.user_name, p.post_id, p.title, p.post, p.post_date from post p,"
				+ "user u where p.user_id=u.user_id and p.post_id=?";
		return jdbcTemplate.queryForObject(selectByPost, new PostDetailsRowMapper(), pid);
	}

	@Override
	public List<Post> findAllByUser(int id, int limit) {
		StringBuilder selectByUser = new StringBuilder("select * from post where user_id=? order by post_date desc");
		if(limit != 0) {
			selectByUser.append(" limit ?");
			return jdbcTemplate.query(selectByUser.toString(), new PostRowMapper(), id, limit);
		}
		else	
			return jdbcTemplate.query(selectByUser.toString(), new PostRowMapper(), id);
	}
	
	@Override
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit, String status){
		StringBuilder recentPost = new StringBuilder("SELECT post_id,title FROM post WHERE user_id = ? and status=? order by post_date desc limit ?");
		if(status != null) {
			return jdbcTemplate.queryForList(recentPost.toString(), uid, status, limit);
		}
		else {
			return jdbcTemplate.queryForList(recentPost.toString(), uid, "P", limit);
			}
	    
	}
	
	@Override
	public List<Map<String, Object>> getRecentPostsByUser(int uid, int limit){
	    return getRecentPostsByUser(uid, limit, null);
	}
	

}

class PostRowMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

		Post post = new Post();
		post.setUserId(rs.getInt(1));
		post.setPostId(rs.getInt(2));
		post.setPostTitle(rs.getString(3));
		post.setPost(rs.getBytes(4));
		post.setPostDate(rs.getTimestamp(5));
		post.setLastUpdateTime(rs.getTimestamp(6));
		post.setPostStatus(rs.getString(7));
		return post;
	}

}

class PostDetailsRowMapper implements RowMapper<PostDetails> {
	@Override
	public PostDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		PostDetails pd = new PostDetails();
		pd.setUserId(rs.getInt(1));
		pd.setUserName(rs.getString(2));
		pd.setPostId(rs.getInt(3));
		pd.setPostTitle(rs.getString(4));
		pd.setPostContent(new String(Base64.getDecoder().decode(rs.getBytes(5))));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			pd.setPostDate(sdf.parse(rs.getTimestamp(6).toString()));
			System.out.println(pd.getPostDate());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

}