package com.example.blog_mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.blog_mvc.dao.UserDao;
import com.example.blog_mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public User findByUserId(int id) {
		String sqlOne = "select * from user where user_id=?";
		return jdbcTemplate.queryForObject(sqlOne, new UserRowMapper(), id);
	}

	@Override
	public User findByUsernameAndPassword(String name, String password) {
		String user = "select * from user where user_name=? and password=?";
		try {
		return jdbcTemplate.queryForObject(user, new UserRowMapper(), name, password);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateUser(User user) {
		String update = "update user set first_name=?, last_name=?, user_name=?, "
				+ "password=?, email=?, phone=?, auth_token=?, street=?, apt=?"
				+ "city=?, state=?, zip=?, country=?, active_flag=?, register_date=? where user_id=?";
		return jdbcTemplate.update(update, user.getFirstName(), user.getLastName(),user.getUserName(),
				user.getPassword(), user.getEmail(), user.getMobile(), user.getAuthToken(), user.getStreet(),
				user.getApt(), user.getCity(), user.getState(), user.getZip(), user.getCountry(), user.getActiveFlag(),
				user.getRegisterDate(), user.getUserId());
	}
	
	

	@Override
	public int saveUser(User user) {
		String insert = "insert into user (first_name, last_name, user_name, "
				+ "password, email, phone, auth_token, street, apt, city, state, "
				+ "zip, country, active_flag, register_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(insert, user.getFirstName(), user.getLastName(),user.getUserName(),
				user.getPassword(), user.getEmail(), user.getMobile(), user.getAuthToken(), user.getStreet(),
				user.getApt(), user.getCity(), user.getState(), user.getZip(), user.getCountry(), user.getActiveFlag(),
				user.getRegisterDate());
	}

	@Override
	public int deleteUser(int id) {
		String inactive = "update user set active_flag=? where user_id=?";
		return jdbcTemplate.update(inactive, "Y", id);
	}

	@Override
	public List<User> findAll(String status) {
		String sql = "select * from user where status=?";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

}

class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setUserName(rs.getString(4));
		user.setPassword(rs.getString(5));
		user.setEmail(rs.getString(6));
		user.setMobile(rs.getString(7));
		user.setAuthToken(rs.getString(8));
		user.setStreet(rs.getString(9));
		user.setApt(rs.getString(10));
		user.setCity(rs.getString(11));
		user.setState(rs.getString(12));
		user.setZip(rs.getInt(13));
		user.setCountry(rs.getString(14));
		user.setActiveFlag(rs.getString(15));
		user.setRegisterDate(rs.getTimestamp(16));
		return user;
	}
	
}