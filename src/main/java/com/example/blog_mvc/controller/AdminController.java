package com.example.blog_mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	private Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("users")
	public ModelAndView viewAllUsersPage(ModelAndView mv) {
		List<User> list = userService.findAllUsers();
		mv.setViewName("users");
		mv.addObject("title", "List of Users");
		if(list != null && list.size() > 0)
			mv.addObject("usersList", list);
		log.debug("number of users fetched: " + list.size());
		return mv;
	}
}
