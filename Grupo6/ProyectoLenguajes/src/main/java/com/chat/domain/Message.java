package com.chat.domain;

import java.sql.Date;

import com.chat.exeption.chatException;

public class Message {
	private int id;
	private String message;
	private Date date;
	private int idSendingUser;
	
	public Message(int id, String message, Date date, int idSendingUser) {
		super();
		if (id < 0)
			throw new chatException("El id del mensaje debe ser mayor  0.");
		if (message == null || message.trim().equals(""))
			throw new chatException("El mensaje es requerido");
		if (id < 0)
			throw new chatException("El id enviando a usuario debe ser mayor  0.");
		if (message == null || message.trim().equals(""))
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
