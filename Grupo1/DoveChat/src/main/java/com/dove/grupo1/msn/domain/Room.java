package com.dove.grupo1.msn.domain;

import java.util.ArrayList;
import java.util.Queue;

public class Room {
	
	private int idRoom; 
	private String name; 
	private ArrayList<User> roomMembers; 
	private User roomAdmin; 
	private User roomOwner;
	private Queue<Message> messageQueue;
	
	
	
	public Room(int idRoom, String name, ArrayList<User> roomMembers, User roomAdmin, User roomOwner,
			Queue<Message> messageQueue) {
		setIdRoom(idRoom);
		setName(name);
		setRoomMembers(roomMembers);
		setRoomOwner(roomOwner);
		setRoomAdmin(roomAdmin);
		setMessageQueue(messageQueue);
	}

	public int getIdRoom() {
		return idRoom;
	}
	
	public void setIdRoom(int idRoom) {
		if(idRoom < 0) throw new RuntimeException("Invalid number for id.");
		this.idRoom = idRoom;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name == null || name.trim().equals("")) throw new RuntimeException("Invalid name.");
		this.name = name;
	}
	
	public ArrayList<User> getRoomMembers() {
		return roomMembers;
	}
	
	public void setRoomMembers(ArrayList<User> roomMembers) {
		if(roomMembers == null ) throw new RuntimeException("ArrayList<User> can't be null.");
		this.roomMembers = roomMembers;
	}
	
	public User getRoomAdmin() {
		return roomAdmin;
	}
	public void setRoomAdmin(User roomAdmin ) {
		if(roomAdmin == null ) throw new RuntimeException("Admin  can't be null.");
		this.roomAdmin = roomAdmin ;
	}
	public User getRoomOwner() {
		return roomOwner;
	}
	public void setRoomOwner(User roomOwner) {
		if(roomOwner == null ) throw new RuntimeException("Owner can't be null.");
		this.roomOwner = roomOwner;
	}
	public Queue<Message> getMessageQueue() {
		return messageQueue;
	}
	public void setMessageQueue(Queue<Message> messageQueue) {
		if(messageQueue == null ) throw new RuntimeException("Queue<Message> can't be null.");
		this.messageQueue = messageQueue;
	}
	
	
	
}
