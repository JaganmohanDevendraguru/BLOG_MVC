package com.example.blog_mvc.controller;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Comment;
import com.example.blog_mvc.model.CommentDetails;
import com.example.blog_mvc.model.PostDetails;
import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.CommentService;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.service.UserService;
import com.example.blog_mvc.util.ActiveStatus;
import com.example.blog_mvc.util.USAStates;
import com.example.blog_mvc.util.UserStatus;
import com.example.blog_mvc.util.Validation;

@Controller
public class HomeController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	private static final String directory = "D:\\WorkSpace\\STS\\BLOG_MVC\\src\\main\\resources\\static\\uploads";
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("title", "Blogger's Home");
		return "home";
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
				mv.setViewName("redirect:user/dashboard");
				session = request.getSession();
				session.setMaxInactiveInterval(1800);
				session.setAttribute("USERSESSION", user);				
			}
			else {
				mv.addObject("error", "Username and Password not match!");
				mv.setViewName("login");
			}
		}
		else {
			mv.addObject("error", "Username/Password cannot be empty");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView processUserAdd(@Valid @ModelAttribute("user") User user, BindingResult result,
			ModelAndView mv) {
		if(result.hasErrors()) {
			log.debug("User add validation error" + result.toString());
			mv.setViewName("register");
			mv.addObject("USStates", USAStates.values());
			mv.addObject("status", UserStatus.values());
			mv.addObject("title", "User Registration");
		}
		else {
			userService.saveUser(user);
			log.info("user added: " + user);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@GetMapping("/register")
	public String viewUserAddPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("USStates", USAStates.values());
		model.addAttribute("status", UserStatus.values());
		model.addAttribute("title", "User Registration");
		return "register";
	}
	
	@GetMapping("/blogs")
	public ModelAndView viewBlogs(ModelAndView mv) {
		mv.setViewName("blogs");
		List<PostDetails> detailsList = postService.fullPostDetails(ActiveStatus.PUBLISHED.getCode());
		mv.addObject("postDetails", detailsList);
		mv.addObject("title", "Blogs");
		return mv;
	}
	
	@GetMapping("/blogs/{postId}")
	public ModelAndView viewSinglePostPage(@PathVariable int postId, ModelAndView mv, HttpSession session) {
		PostDetails post = postService.singlePostDetails(postId);
		if(post != null) {
			mv.setViewName("singlePostDetails");
			mv.addObject("pd", post);
			mv.addObject("title", post.getPostTitle());
			List<CommentDetails> comments = commentService.singlePostCommentDetails(postId);
			if(comments != null && comments.size() > 0) {
				mv.addObject("comments", comments);
			}
			else {mv.addObject("error", "No comments yet. Be the first one");}
			
			if(session.getAttribute("USERSESSION") !=null)
				mv.addObject("comment", new Comment());
		}
		else {
			mv.setViewName("redirect:blogs");
		}
		
		return mv;
	}
	
	@PostMapping("/blogs/{postId}")
	public ModelAndView addCommentToSinglePostPage(@PathVariable int postId, ModelAndView mv, HttpSession session
			, @Valid @ModelAttribute("comment") Comment comment, BindingResult result) {
		PostDetails post = postService.singlePostDetails(postId);
		if(post != null) {
			mv.setViewName("singlePostDetails");
			mv.addObject("pd", post);
			mv.addObject("title", post.getPostTitle());
			User user = Validation.getUserSession(session);
			if (user != null) {
				if(result.hasErrors()) {
					mv.setViewName("forward:blogs/"+post.getPostId());
				}
				comment.setPostId(postId);
				comment.setUserId(user.getUserId());
				int insert = commentService.saveComment(comment);
			}
			List<CommentDetails> comments = commentService.singlePostCommentDetails(postId);
			if(comments != null && comments.size() > 0) {
				mv.addObject("comments", comments);
			}
			else {mv.addObject("error", "No comments yet. Be the first one");}
			
			if(session.getAttribute("USERSESSION") !=null)
				mv.addObject("comment", new Comment());
		}
		else {
			mv.setViewName("redirect:blogs");
		}
		
		return mv;
	}
	
	@GetMapping("/upload")
	public String uploadForm(Model model) {
		model.addAttribute("files", postService.showFiles(directory));
		return "fileUpload";
	}
	
	@PostMapping("/upload")
	public ModelAndView uploadProcess(ModelAndView mv, @RequestParam("image") MultipartFile file) {
		postService.upload(file, directory);
		mv.setViewName("home");
		return mv;
	}
}
