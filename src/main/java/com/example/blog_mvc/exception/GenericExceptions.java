package com.example.blog_mvc.exception;

import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptions {
	
	private Logger log = LoggerFactory.getLogger(GenericExceptions.class);

	@ExceptionHandler(value= SQLException.class)
	public String handleSql(HttpServletRequest request, Exception e) {
		log.error("Request: " + request.getRequestURI() + " raised an exception");
		log.error("Exception Id is: " +Calendar.getInstance().getTimeInMillis());
		e.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public String handleRuntime(HttpServletRequest request, Exception e) {
		log.error("Request: " + request.getRequestURI() + " raised an exception");
		log.error("Exception Id is: " +Calendar.getInstance().getTimeInMillis());
		e.printStackTrace();
		return "error";
	}
}
