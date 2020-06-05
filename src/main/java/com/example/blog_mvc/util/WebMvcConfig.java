package com.example.blog_mvc.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new SessionInterceptor())
        .addPathPatterns("/user/**");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringBase64ToByteArray());
		registry.addConverter(new ByteArrayToStringBase64());
	}
	
}
