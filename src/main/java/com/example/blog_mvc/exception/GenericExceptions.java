package com.example.blog_mvc.exception;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptions {
	
	private Logger log = LoggerFactory.getLogger(GenericExceptions.class);

	@ExceptionHandler(value= RuntimeException.class)
	public String notFound() {
		log.error("Runtime exception occured: " + Calendar.getInstance().getTimeInMillis());
		return "error";
	}
}
