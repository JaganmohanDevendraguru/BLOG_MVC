package com.example.blog_mvc.util;

public enum ActiveStatus {

	PUBLISHED("P","Publish"),
	DRAFT("DR","Draft"),
	EDIT("E","Edit"),
	BLOCKED("X","Block"),
	DELETED("D","Delete"),
	SCHEDULED("S","Schedule");
	
	private String code;
	private String display;
	
	private ActiveStatus(String code, String display) {
		this.code=code;
		this.display=display;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getDisplay() {
		return display;
	}
}
