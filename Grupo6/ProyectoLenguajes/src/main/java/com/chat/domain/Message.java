package com.chat.domain;

import java.sql.Date;

public class Message {
	private int id;
	private String message;
	private Date date;
	private int idSendingUser;
	
	public Message(int id, String message, Date date, int idSendingUser) {
		super();
		if (id < 0)
			throw new RuntimeException("El id del mensaje debe ser mayor  0.");
		if (message == null || message.trim().equals(""))
			throw new RuntimeException("El mensaje es requerida es requerido");
		this.id = id;
		this.message = message;
		this.date = date;
		this.idSendingUser = idSendingUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdSendingUser() {
		return idSendingUser;
	}
	public void setIdSendingUser(int idSendingUser) {
		this.idSendingUser = idSendingUser;
	}
}
