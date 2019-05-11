package com.dove.grupo1.msn.domain;

import java.util.Date;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public class Message {

	private User sender; 
	private int idRoom; 
	private String text; 
	private Date shipDate; 
	private Date shipHour;
	
	
	
	public Message(User sender, int idRoom, String text, Date shipDate, Date shipHour) {
		setSender(sender);
		setIdRoom(idRoom);
		setText(text);
		setShipDate(shipDate);
		setShipHour(shipHour);
	}
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		if(sender == null) throw new RuntimeException("User can't be null.");
		this.sender = sender;
	}
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		if(idRoom < 0) throw new RuntimeException("Invalid number.");
	 	this.idRoom = idRoom;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		if(text == null || text.trim().equals("")) throw new RuntimeException("Invalid text.");
		this.text = text;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		if(shipDate == null) throw new RuntimeException("Ship Date can't be null.");
		this.shipDate = shipDate;
	}
	public Date getShipHour() {
		return shipHour;
	}
	public void setShipHour(Date shipHour) {
		if(shipDate == null) throw new RuntimeException("Ship Hour can't be null.");
		this.shipHour = shipHour;
	} 
	
}
