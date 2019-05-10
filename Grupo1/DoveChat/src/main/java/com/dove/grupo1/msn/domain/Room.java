package com.dove.grupo1.msn.domain;

import java.util.ArrayList;
import java.util.Queue;

public class Room {
	
	private int idRoom; 
	private String name; 
	private ArrayList<User> roomMembers; 
	private User roomUser; 
	private User roomOwner;
	private Queue<Message> messageQueue;
	
	
	
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<User> getRoomMembers() {
		return roomMembers;
	}
	public void setRoomMembers(ArrayList<User> roomMembers) {
		this.roomMembers = roomMembers;
	}
	public User getRoomUser() {
		return roomUser;
	}
	public void setRoomUser(User roomUser) {
		this.roomUser = roomUser;
	}
	public User getRoomOwner() {
		return roomOwner;
	}
	public void setRoomOwner(User roomOwner) {
		this.roomOwner = roomOwner;
	}
	public Queue<Message> getMessageQueue() {
		return messageQueue;
	}
	public void setMessageQueue(Queue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	
	
	
}
