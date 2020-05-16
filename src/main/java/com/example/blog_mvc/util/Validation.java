package com.example.blog_mvc.util;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

public class Validation {

	public static boolean isNull(String s) {
		if(s != null && !s.isEmpty() && s.trim().equals(""))
			return false;
		return true;
	}
	
	public static boolean isValidSession(HttpSession session, int time) {
		boolean result = false;
		long lastAccess = 0;
		long now = Calendar.getInstance().getTimeInMillis();
		if (session != null) {
			lastAccess = session.getLastAccessedTime();
			if((now - lastAccess) < time)
				result = true;
		}
			
		return result;
	}
}
