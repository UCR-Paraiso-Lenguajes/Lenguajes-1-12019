package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;

public class User {
	private int user_id;
	private String user_email;
	private ArrayList <Role> roles;
	private String hash;
	private int numberMessages;
	
	public User(int user_id, String user_email, ArrayList<Role> roles, String hash) {
		this.user_id = user_id;
		this.user_email = user_email;
		this.roles = roles;
		this.hash = hash;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public User(int user_id, String user_email, int numberMessages) {
		this.user_id = user_id;
		this.user_email = user_email;
		this.numberMessages = numberMessages;
	}

	public String decideNameAnonimous() {
		//TODO Falta la logica 
		return null;
	}
	
	public String recoverNameAnonimous() {
		//TODO Falta logica
		return null;
	}
	
	public String decideAvatar() {
		//TODO Falta la logica 
		return null;
	}
	
	public String recoverAvatar() {
		//TODO Falta logica
		return null;
	}
	

}

