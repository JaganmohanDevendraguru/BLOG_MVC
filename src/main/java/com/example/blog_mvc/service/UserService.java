package com.example.blog_mvc.service;

import java.util.List;

import com.example.blog_mvc.model.User;

public interface UserService {

	public abstract List<User> findAll();
	public abstract User findByUserId(int id);
	public abstract User findByUsernameAndPassword();
	public abstract int updateUser(User user);
	public abstract int deleteUser(int id);
	public abstract List<User> findAll(String status);
}
