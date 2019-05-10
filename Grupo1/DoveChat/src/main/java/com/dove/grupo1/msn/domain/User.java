package com.dove.grupo1.msn.domain;

public class User {
	
	private int userId;
	private String username; 
	private String email;
	private String avatarImagePath;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatarImagePath() {
		return avatarImagePath;
	}
	public void setAvatarImagePath(String avatarImagePath) {
		this.avatarImagePath = avatarImagePath;
	}
	
	
	
}
