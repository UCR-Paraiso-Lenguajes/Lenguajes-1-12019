package com.proyectoUno.grupo5.domain;

import java.util.Date;

public class Metrics {
	
	private int idmetrics;
	private int quantityOfRooms;
	private int quantityOfUsers;
	private int averageUsersForRooms;
	private Date dateOfLastMessage;
	private Date dateOfFirstLogin;
	private User userWithMoreMessage;
	private Message longerMesssage;
	private Room lastGroupCreate;
	private Room roomWithMoreMessage;
	
	
	public Metrics(int idmetrics,int quantityOfRooms, int quantityOfUsers, int averageUsersForRooms, Date dateOfLastMessage,
                   Date dateOfFirstLogin, User userWithMoreMessage, Message longerMesssage, Room lastGroupCreate,
                   Room roomWithMoreMessage) {
		
		super();
		this.idmetrics=idmetrics;
		this.quantityOfRooms = quantityOfRooms;
		this.quantityOfUsers = quantityOfUsers;
		this.averageUsersForRooms = averageUsersForRooms;
		this.dateOfLastMessage = dateOfLastMessage;
		this.dateOfFirstLogin = dateOfFirstLogin;
		this.userWithMoreMessage = userWithMoreMessage;
		this.longerMesssage = longerMesssage;
		this.lastGroupCreate = lastGroupCreate;
		this.roomWithMoreMessage = roomWithMoreMessage;
	}


	public Metrics() {
		super();
	}


	public int getQuantityOfRooms() {
		return quantityOfRooms;
	}


	public void setQuantityOfRooms(int quantityOfRooms) {
		this.quantityOfRooms = quantityOfRooms;
	}


	public int getIdmetrics() {
		return idmetrics;
	}


	public void setIdmetrics(int idmetrics) {
		this.idmetrics = idmetrics;
	}


	public int getQuantityOfUsers() {
		return quantityOfUsers;
	}


	public void setQuantityOfUsers(int quantityOfUsers) {
		this.quantityOfUsers = quantityOfUsers;
	}


	public int getAverageUsersForRooms() {
		return averageUsersForRooms;
	}


	public void setAverageUsersForRooms(int averageUsersForRooms) {
		this.averageUsersForRooms = averageUsersForRooms;
	}


	public Date getDateOfLastMessage() {
		return dateOfLastMessage;
	}


	public void setDateOfLastMessage(Date dateOfLastMessage) {
		this.dateOfLastMessage = dateOfLastMessage;
	}


	public Date getDateOfFirstLogin() {
		return dateOfFirstLogin;
	}


	public void setDateOfFirstLogin(Date dateOfFirstLogin) {
		this.dateOfFirstLogin = dateOfFirstLogin;
	}


	public User getUserWithMoreMessage() {
		return userWithMoreMessage;
	}


	public void setUserWithMoreMessage(User userWithMoreMessage) {
		this.userWithMoreMessage = userWithMoreMessage;
	}


	public Message getLongerMesssage() {
		return longerMesssage;
	}


	public void setLongerMesssage(Message longerMesssage) {
		this.longerMesssage = longerMesssage;
	}


	public Room getLastGroupCreate() {
		return lastGroupCreate;
	}


	public void setLastGroupCreate(Room lastGroupCreate) {
		this.lastGroupCreate = lastGroupCreate;
	}


	public Room getRoomWithMoreMessage() {
		return roomWithMoreMessage;
	}


	public void setRoomWithMoreMessage(Room roomWithMoreMessage) {
		this.roomWithMoreMessage = roomWithMoreMessage;
	}
	
	
	
	

}
