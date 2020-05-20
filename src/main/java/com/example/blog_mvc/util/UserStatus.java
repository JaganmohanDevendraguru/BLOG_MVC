package com.example.blog_mvc.util;

public enum UserStatus {

	ACTIVE("Y"),
	INACTIVE("N"),
	BLOCKED("X"),
	DELETED("D");
	private String code;
	
	private UserStatus(String code) {
		this.code=code;
	}
	
	public String getUSerStatus() {
		return code;
	}
}
