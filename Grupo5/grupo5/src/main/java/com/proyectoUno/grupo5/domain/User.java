package com.proyectoUno.grupo5.domain;

import java.util.ArrayList;

public class User {

	private int idUser;
	private String email;
	private String username;
	private String avatar;
	private ArrayList<Role> roleUser;
	private ArrayList<Message> messages;
	private ArrayList<Room> rooms;
	private String hash;
	private int idRole;
	
	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public User(int idUser, String email, String username, String avatar, ArrayList<Role> roleUser,
                ArrayList<Message> messages, ArrayList<Room> rooms, String hash) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.username = username;
		this.avatar = avatar;
		this.roleUser = roleUser;
		this.messages = messages;
		this.rooms = rooms;
		this.hash = hash;
	}

	public User() {
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public ArrayList<Role> getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(ArrayList<Role> roleUser) {
		this.roleUser = roleUser;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
