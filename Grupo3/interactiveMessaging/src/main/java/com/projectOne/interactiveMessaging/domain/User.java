package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;

public class User {
	private int user_id;
	private String user_email;
	private ArrayList <Role> roles;
	private String hash;
	
	public User(int user_id, String user_email, ArrayList<Role> roles, String hash) {
		super();
		this.user_id = user_id;
		this.user_email = user_email;
		this.roles = roles;
		this.hash = hash;
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
