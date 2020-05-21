package com.example.blog_mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.UserService;

/*
 * 
 * User related paths and controller. The base url is /users
 */
@Controller
@RequestMapping("/user/posts")
public class UserController {
	
	@Autowired
	private UserService service;
	
	private Logger log =LoggerFactory.getLogger(UserController.class);

	public ModelAndView viewAllUsersPage(ModelAndView mv) {
		List<User> list = service.findAllUsers();
		mv.setViewName("users");
		mv.addObject("title", "List of Users");
		if(list != null && list.size() > 0)
			mv.addObject("usersList", list);
		log.debug("number of users fetched: " + list.size());
		return mv;
	}
	
	@GetMapping(value="dashboard")
	public String viewDashboard(ModelAndView mv) {
		mv.addObject("title", "Dashboard");
		return "dashboard";
	}
	
	@GetMapping(value="create")
	public String viewCreatePost(Model mv) {
		log.info("create worked");
		mv.addAttribute("p", new Post());
		mv.addAttribute("title", "Post Creation");
		return "createPost";
	}
	
	@PostMapping(value="create")
	public ModelAndView processPostCreation(@Valid @ModelAttribute("p") Post post, BindingResult result, ModelAndView mv) {
		mv.addObject("title", "Post Creation");
		return mv;
	}
}
