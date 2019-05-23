package com.projectOne.interactiveMessaging.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Room {
	
	private int group_id;
	private String name_Room;
	private Timestamp dateCreate;
	private User owner;
	private User admin;
	public Room(int group_id, String name_Room, Timestamp dateCreate) {
		this.group_id = group_id;
		this.name_Room = name_Room;
		this.dateCreate = dateCreate;
	}

	private ArrayList <User> users;
	
	public Room(int group_id,String name_Room, Timestamp dateCreate, User owner, User admin, ArrayList<User> users) {
		
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
	
	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getName_Room() {
		return name_Room;
	}

	public void setName_Room(String name_Room) {
		this.name_Room = name_Room;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}
	
	

}
