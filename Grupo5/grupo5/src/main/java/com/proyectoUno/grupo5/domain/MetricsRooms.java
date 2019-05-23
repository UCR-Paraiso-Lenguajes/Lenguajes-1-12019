package com.proyectoUno.grupo5.domain;

import java.util.Date;

public class MetricsRooms {

	private int idMetricsRoom;
	private User userWithMoreMessage;
	private Message longerMesssage;
	private Date dateOfLastMessage;
	private Room room;
	
	
	public MetricsRooms(int idMetricsRoom, User userWithMoreMessage, Message longerMesssage, Date dateOfLastMessage,
			Room room) {
		super();
		this.idMetricsRoom = idMetricsRoom;
		this.userWithMoreMessage = userWithMoreMessage;
		this.longerMesssage = longerMesssage;
		this.dateOfLastMessage = dateOfLastMessage;
		this.room = room;
	}
	
	public int getIdMetricsRoom() {
		return idMetricsRoom;
	}
	public void setIdMetricsRoom(int idMetricsRoom) {
		this.idMetricsRoom = idMetricsRoom;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
	public Date getDateOfLastMessage() {
		return dateOfLastMessage;
	}
	public void setDateOfLastMessage(Date dateOfLastMessage) {
		this.dateOfLastMessage = dateOfLastMessage;
	}
	
}
