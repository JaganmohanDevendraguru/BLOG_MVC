package com.example.blog_mvc.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.model.User;
import com.example.blog_mvc.service.PostService;

@Controller
@RequestMapping("/user/posts")
public class PostController {

	private Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;
	
	@Autowired
	private HttpSession session;

	@GetMapping()
	public ModelAndView viewAllPostsPage(ModelAndView mv) {
		List<Post> list = postService.findAll();
		mv.setViewName("posts");
		mv.addObject("title", "List of Posts");
		if (list != null && list.size() > 0)
			mv.addObject("postList", list);
		log.debug("number of posts fetched: " + list.size());
		return mv;
	}

	@GetMapping(value = "create")
	public String viewCreatePost(Model mv) {
		log.info("create worked");
		mv.addAttribute("p", new Post());
		mv.addAttribute("title", "Post Creation");
		return "createPost";
	}

	@PostMapping(value = "create")
	public ModelAndView processPostCreation(@Valid @ModelAttribute("p") Post post,
			@RequestParam(required = false, value = "save") String draftFlag,
			@RequestParam(required = false, value = "publish") String publishFlag, BindingResult result,
			ModelAndView mv) {
		int dbStatus = 0;
		if (result.hasErrors()) {
			mv.setViewName("create");
		} else {
			mv.setViewName("create");
			User user = (User)session.getAttribute("USERSESSION");
			post.setUserId(user.getUserId());
			dbStatus = postService.savePost(post, draftFlag != null ? draftFlag : publishFlag);
			if (dbStatus == 1)
				mv.setViewName("redirect:/user/posts");
			else {
				mv.setViewName("create");
				mv.addObject("error", "Error occured while inserting!");
			}
		}
		return mv;
	}

	@GetMapping("edit")
	public ModelAndView showPostEditPage(@RequestParam("id") int postId, ModelAndView mv) {
		User user = (User)session.getAttribute("USERSESSION");
		Post post = postService.findByPostById(user.getUserId(), postId);
		if (post != null) {
			mv.addObject("title", "Edit Post");
			mv.addObject("post", post);
			mv.setViewName("editPost");
		} else {
			mv.setViewName("redirect:/user/posts");
			mv.addObject("error", "Could not find the post");
		}
		return mv;
	}

}
