package com.example.blog_mvc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.service.UserService;

/*
 * 
 * User related paths and controller. The base url is /users
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	private Logger log =LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value="dashboard")
	public String viewDashboard(ModelAndView mv) {
		mv.addObject("title", "Dashboard");
		return "dashboard";
	}
	
	@GetMapping(value="profile")
	public String viewProfile(ModelAndView mv) {
		mv.addObject("title", "Profile Details");
		return "profile";
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
