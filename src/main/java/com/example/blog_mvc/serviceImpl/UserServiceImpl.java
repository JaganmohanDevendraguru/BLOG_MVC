package com.example.blog_mvc.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsernameAndPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
