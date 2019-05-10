package com.dove.grupo1.msn.domain;

import java.util.Date;

public class Message {

	private User sender; 
	private int idRoom; 
	private String text; 
	private Date shipDate; 
	private Date shipHour;
	
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public Date getShipHour() {
		return shipHour;
	}
	public void setShipHour(Date shipHour) {
		this.shipHour = shipHour;
	} 
	
	
	
}
