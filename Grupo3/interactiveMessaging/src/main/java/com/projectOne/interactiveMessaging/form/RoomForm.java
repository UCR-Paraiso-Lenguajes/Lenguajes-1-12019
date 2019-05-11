package com.projectOne.interactiveMessaging.form;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.projectOne.interactiveMessaging.domain.User;

public class RoomForm {
	@NotNull
	private int group_id;
	@Email
	@NotNull
	private String name_Room;
	@NotNull
	@Past //Utilizo past como posible opcion para indicar que la fecha no puede ser posterior a la de envio
	private Date dateCreate;
	private User owner;
	private User admin;
	private ArrayList <User> users;
	
	public RoomForm() {
		super();
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

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
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
	
	

}
