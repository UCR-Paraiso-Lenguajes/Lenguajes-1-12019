package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.Date;

public class Room {
	
	private int group_id;
	private String name_Room;
	private Date dateCreate;
	private User owner;
	private User admin;
	private ArrayList <User> users;
	
	public Room(int group_id,String name_Room, Date dateCreate, User owner, User admin, ArrayList<User> users) {
		
		if(dateCreate == null) throw new RuntimeException("La fecha es requerida.");
		if(name_Room == null || name_Room.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre del grupo es requerido.");
		if(users == null || users.size() == 0) throw new RuntimeException("El grupo debe tener al menos dos usuarios.");
		//Los administradores no se evaluan porque puede ser owner pero no admin y viceversa
		this.group_id = group_id;
		this.name_Room = name_Room;
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
