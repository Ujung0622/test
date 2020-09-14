package com.spring.mvc.ex04.component;

public class Auth {

	private String id;
	private String name;

	public Auth(String email, String name) {
		this.id = email;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
