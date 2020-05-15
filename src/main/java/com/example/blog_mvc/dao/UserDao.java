package com.example.blog_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.blog_mvc.model.User;

@Repository
public interface UserDao {

	public abstract List<User> findAll();
	public abstract User findByUserId(int id);
	public abstract User findByUsernameAndPassword(String name, String password);
	public abstract int saveUser(User user);
	public abstract int updateUser(User user);
	public abstract int deleteUser(int id);
	public abstract List<User> findAll(String status);
}
