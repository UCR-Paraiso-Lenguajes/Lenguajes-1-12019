package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.Date;

public class Room {
	
	private int group_id;
	private Date dateCreate;
	private User owner;
	private User admin;
	private ArrayList <User> users;
	
	public Room(int group_id, Date dateCreate, User owner, User admin, ArrayList<User> users) {
		super();
		this.group_id = group_id;
		this.dateCreate = dateCreate;
		this.owner = owner;
		this.admin = admin;
		this.users = users;
	}
	
	public void sendMessage (String message) {
		//TODO falta logica
	}
	
	private void limitCharacters(String Message) {
		//TODO falta logica
	}
	
	public String decideAccessPath() {
		//TODO falta logica
		return null;
	}
	
	public Date getDateCreate() {
		//TODO falta logica 
		return null;
	}
	
	public String createRoom (User user) {
		//TODO falta logica 
		return null;
	}
	
	public void recoverStatus() {
		//TODO falta Logica
	}
	

}
