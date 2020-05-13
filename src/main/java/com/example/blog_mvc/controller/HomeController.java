package com.example.blog_mvc.controller;

import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Post;

@Controller
public class HomeController{
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String viewHome() {
		log.info("Logger worked!");
		return "home";
	}
	
	@GetMapping("/blogs")
	public ModelAndView viewBlogs() {
		ModelAndView mv = new ModelAndView("blogs");
		log.info("blogs");
		Set<Post> postTreeSet = new TreeSet<>();
		mv.addObject("postDetails", postTreeSet);
		return mv;
	}

}
