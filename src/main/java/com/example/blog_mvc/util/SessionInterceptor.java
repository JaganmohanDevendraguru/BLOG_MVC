package com.example.blog_mvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.blog_mvc.model.User;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("SessionInterceptor logged at: " + System.currentTimeMillis());
		HttpSession session = request.getSession(false);
		log.info("current session: " + session);

		if (session == null) {
			log.info("session is null returning false and to login page");
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else {
			User user = (User) session.getAttribute("USERSESSION");
			if (user == null) {
				log.info("USERSESSION is null...");
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// modelAndView.addObject("error", "Invalid Session. Login again");
		// modelAndView.setViewName("login");
		System.out.println("postHandle print");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}
