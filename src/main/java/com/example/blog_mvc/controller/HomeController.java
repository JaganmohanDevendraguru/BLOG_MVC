package com.example.blog_mvc.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.CommentService;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.service.UserService;
import com.example.blog_mvc.util.Validation;

@Controller
public class HomeController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
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

	@GetMapping("/login")
	public ModelAndView viewLoginPage(ModelAndView mv) {
			mv.setViewName("login");
			mv.addObject("title", "User Login Form");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView proccessLogin(ModelAndView mv, @RequestParam("userName") String uname, @RequestParam("password") String pass,
			HttpSession session, HttpServletRequest request) {
		if (!Validation.isNull(uname) && !Validation.isNull(pass)) {
			User user = userService.findByUsernameAndPassword(uname, pass);
			if(user != null) {
				mv.setViewName("redirect:dashboard");
				mv.addObject("title", "User Home Page");
				session = request.getSession();
				session.setMaxInactiveInterval(1800);
				session.setAttribute("USERSESSION", user);				
			}
			else {
				mv.addObject("error", "Username and Password not match!");
				mv.setViewName("login");
				mv.addObject("title", "User Login page");
			}
		}
		else {
			mv.addObject("error", "Username/Password cannot be empty");
			mv.setViewName("login");
			mv.addObject("title", "User Login page");
		}
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView processUserAdd(@Valid @ModelAttribute("user") User user, BindingResult result,
			ModelAndView mv) {
		if(result.hasErrors()) {
			log.debug("User add validation error" + result.toString());
			mv.setViewName("add");
		}
		else {
			userService.saveUser(user);
			log.debug("user added: " + user);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@GetMapping("/register")
	public String viewUserAddPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "User Registration");
		return "userAdd";
	}
	
	@GetMapping("/blogs/{postId}")
	public ModelAndView viewSinglePostPage(@PathVariable int postId, ModelAndView mv) {
		Post post = postService.findByPostById(postId);
		if(post != null) {
			mv.setViewName("singlePostDetails");
			mv.addObject("post", post);
			mv.addObject("title", post.getPostTitle());
			List<Comment> comments = commentService.findAllByPost(postId);
			if(comments != null && comments.size() > 0) {
				mv.addObject("comments", comments);
			}
			else {mv.addObject("error", "No comments yet. Be the first one");}
		}
		else {
			mv.setViewName("redirect:blogs");
		}
		
		return mv;
	}
}
