package com.example.blog_mvc.serviceImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_mvc.dao.UserDao;
import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public List<User> findAllUsers() {
		return dao.findAll();
	}

	@Override
	public User findByUserId(int id) {
		return dao.findByUserId(id);
	}

	@Override
	public User findByUsernameAndPassword(String name, String password) {
		return dao.findByUsernameAndPassword(name, password);
	}

	@Override
	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public int saveUser(User user) {
		user.setRegisterDate(Calendar.getInstance().getTime());
		return dao.saveUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return dao.deleteUser(id);
	}

	@Override
	public List<User> findAll(String status) {
		return dao.findAll(status);
	}

}
