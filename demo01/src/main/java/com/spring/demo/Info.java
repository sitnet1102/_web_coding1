package com.spring.demo;

public class Info {
	String id;
	String pw;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo() {
		System.out.println("id : " + id + " pw : " + pw + " name : " + name);
	}
	
}
