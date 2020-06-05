package com.example.blog_mvc.util;

import javax.servlet.http.HttpSession;

import com.example.blog_mvc.model.User;

public class Validation {

	public static boolean isNull(String s) {
		if(s != null && !s.isEmpty() && !s.trim().equals(""))
			return false;
		return true;
	}
	
	public static boolean isValidSession(HttpSession session, int time) {
		boolean result = false;
		if (session != null) {
			User user = (User)session.getAttribute("USERSESSION");
			if(user != null)
				result = true;
		}
			
		return result;
	}
	
	public static User getUserSession(HttpSession session) {
		User user = null;
		if (session != null) {
			user = (User)session.getAttribute("USERSESSION");
			if(user != null)
				return user;
		}
			
		return user;
	}
}
