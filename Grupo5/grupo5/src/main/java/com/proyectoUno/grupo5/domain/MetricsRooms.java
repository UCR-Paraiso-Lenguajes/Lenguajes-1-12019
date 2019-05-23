package com.proyectoUno.grupo5.domain;

import java.util.Date;

public class MetricsRooms {

	private int idMetricsRoom;
	private String userWithMoreMessage;
	private String longerMesssage;
	private Date dateOfLastMessage;
	private int idRoom;
	
	
	public MetricsRooms(int idMetricsRoom, String userWithMoreMessage, String longerMesssage, Date dateOfLastMessage,
			int idRoom) {
		super();
		this.idMetricsRoom = idMetricsRoom;
		this.userWithMoreMessage = userWithMoreMessage;
		this.longerMesssage = longerMesssage;
		this.dateOfLastMessage = dateOfLastMessage;
		this.idRoom = idRoom;
	}
	
	public MetricsRooms() {
		// TODO Auto-generated constructor stub
	}

	public int getIdMetricsRoom() {
		return idMetricsRoom;
	}
	public void setIdMetricsRoom(int idMetricsRoom) {
		this.idMetricsRoom = idMetricsRoom;
	}
	public int getRoom() {
		return idRoom;
	}
	public void setRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getUserWithMoreMessage() {
		return userWithMoreMessage;
	}
	public void setUserWithMoreMessage(String string) {
		this.userWithMoreMessage = string;
	}
	public String getLongerMesssage() {
		return longerMesssage;
	}
	public void setLongerMesssage(String string) {
		this.longerMesssage = string;
	}
	public Date getDateOfLastMessage() {
		return dateOfLastMessage;
	}
	public void setDateOfLastMessage(Date dateOfLastMessage) {
		this.dateOfLastMessage = dateOfLastMessage;
	}
	
}
