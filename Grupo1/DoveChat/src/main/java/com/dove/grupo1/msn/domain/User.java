package com.dove.grupo1.msn.domain;

public class User {
	
	private int userId;
	private String userName; 
	private String email;
	
	
	
	public User(int userId, String userName, String email) {	
		setUserId(userId);
		setUserName(userName);
		setEmail(email);
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		if(userId < 0) throw new RuntimeException("Invalid user id.");
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		if(username == null || username.trim().equals("")) throw new RuntimeException("Invalid user name.");
		this.userName = username;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email == null || email.trim().equals("")) throw new RuntimeException("Invalid user email.");
		this.email = email;
	}
	
	
	
}
