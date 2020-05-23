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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.blog_mvc.model.Post;
import com.example.blog_mvc.service.PostService;
import com.example.blog_mvc.util.PostStatus;

@Controller
@RequestMapping("/user/posts")
public class PostController {

	private Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	public ModelAndView viewAllPostsPage(ModelAndView mv) {
		List<Post> list = postService.findAll();
		mv.setViewName("posts");
		mv.addObject("title", "List of Posts");
		if (list != null && list.size() > 0)
			mv.addObject("usersList", list);
		log.debug("number of users fetched: " + list.size());
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
			@RequestParam(required = false, value = "save") String saveFlag,
			@RequestParam(required = false, value = "publish") String publishFlag, BindingResult result,
			ModelAndView mv) {
		log.info("Post button" + post.getStatus());
		log.info("SaveFlag" + saveFlag + " and PublishFlag" + publishFlag);
		if (result.hasErrors()) {
			mv.setViewName("create");
		} else {
			if (saveFlag != null)
				post.setStatus(PostStatus.DRAFT.getStatus());
			if (publishFlag != null)
				post.setStatus(PostStatus.PUBLISHED.getStatus());
			mv.setViewName("create");
			log.info("Post" + post);
			mv.setViewName("redirect:/user/posts");
		}
		return mv;
	}

}
