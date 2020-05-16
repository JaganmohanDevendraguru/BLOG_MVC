package com.example.blog_mvc.service;

import java.util.List;

import com.example.blog_mvc.model.User;

public interface UserService {

	public abstract List<User> findAllUsers();
	public abstract User findByUserId(int id);
	public abstract User findByUsernameAndPassword(String name, String password);
	public abstract int updateUser(User user);
	public abstract int saveUser(User user);
	public abstract int deleteUser(int id);
	public abstract List<User> findAll(String status);
}
