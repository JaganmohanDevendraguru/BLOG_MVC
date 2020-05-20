package com.example.blog_mvc.util;

public enum PostStatus {

	PUBLISHED("P"),
	DRAFT("DR"),
	EDIT("E"),
	BLOCKED("X"),
	DELETED("D"),
	SCHEDULED("S");
	
	private String code;
	
	private PostStatus(String code) {
		this.code=code;
	}
	
	public String getStatus() {
		return code;
	}
}
