package com.example.blog_mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.service.UserService;
import com.example.blog_mvc.util.USAStates;
import com.example.blog_mvc.util.UserStatus;
import com.example.blog_mvc.util.Validation;

/*
 * 
 * User related paths and controller. The base url is /users
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;
	
	private Logger log =LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value="dashboard")
	public ModelAndView viewDashboard(ModelAndView mv, HttpSession session) {
		mv.addObject("title", "Dashboard");
		mv.setViewName("dashboard");
		List<Map<String, Object>> recentPosts= postService.getRecentPostsByUser(Validation.getUserSession(session).getUserId(), 5);
		List<Map<String, Object>> draftPosts= postService.getRecentPostsByUser(Validation.getUserSession(session).getUserId(), 5, "DR");
		log.info("posts fetched in recentPost: " + recentPosts.size());
		mv.addObject("recentPosts", recentPosts);
		mv.addObject("draftPosts", draftPosts);
		return mv;
	}
	
	@GetMapping(value="profile")
	public ModelAndView viewProfile(ModelAndView mv, HttpSession session) {
		mv.addObject("title", "Profile Details");
		mv.setViewName("profile");
		User user = Validation.getUserSession(session);
		mv.addObject("user", user);
		mv.addObject("status", UserStatus.values());
		mv.addObject("USStates", USAStates.values());
		return mv;
	}
	
	@GetMapping("/logout")
	public String logoutPage(Model model, HttpSession session) {
		if(session.getAttribute("USERSESSION") != null)
		{
			session.setMaxInactiveInterval(0);
			session.invalidate();
			model.addAttribute("message", "You are successfully logged out");
			return "logout";
		}
		model.addAttribute("error", "No valid session");
		return "redirect:/login";
	}
}
