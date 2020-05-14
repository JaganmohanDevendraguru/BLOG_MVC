package com.example.blog_mvc.controller;

import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Post;

@Controller
public class HomeController{
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String viewHome(Model model) {
		log.info("Logger worked!");
		model.addAttribute("title", "Blogger's Home");
		return "home";
	}
	
	@GetMapping("/blogs")
	public ModelAndView viewBlogs(ModelAndView mv) {
		mv.setViewName("blogs");
		log.info("blogs");
		Set<Post> postTreeSet = new TreeSet<>();
		mv.addObject("postDetails", postTreeSet);
		return mv;
	}
	
	@GetMapping(value="/login")
	public String viewLogin(Model model) {
		model.addAttribute("title", "Login Form");
		return "login";
	}
	
	@PostMapping(value="/login")
	public String processLogin(@RequestParam("userName") String name) {
		
		if(name.equals(""))
			throw new RuntimeException("Username is empty!");
		return "redirect:dashboard";
	}
	
	@GetMapping(value="/dashboard")
	public String viewDashboard(ModelAndView mv) {
		mv.addObject("title", "Dashboard");
		return "dashboard";
	}

}
