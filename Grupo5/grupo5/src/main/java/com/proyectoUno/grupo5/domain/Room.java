package com.proyectoUno.grupo5.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
	
	private int idRoom;
	private String roomName;
	private int version;	
	private Map<Integer, Message> messages;
	private ArrayList<User> users;
	
	public Room(int idRoom, String roomName, int version, Map<Integer, Message> messages, ArrayList<User> users) {
		super();
		this.idRoom = idRoom;
		this.roomName = roomName;
		this.version = version;
		this.messages = messages;
		this.users = users;
	}

	public Room() {
	}

	public Room(String roomName, int version) {
		this.roomName = roomName;
		this.version = version;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Map<Integer, Message> getMessages() {
		return messages;
	}

	public void setMessages(HashMap<Integer, Message> messages) {
		this.messages = messages;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	
}