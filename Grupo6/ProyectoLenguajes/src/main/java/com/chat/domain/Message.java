package com.chat.domain;

public class Message {
	private int id;
	private String message;
	private String date;
	private int idSendingUser;
	
	public Message(int id, String message, String date, int idSendingUser) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdSendingUser() {
		return idSendingUser;
	}
	public void setIdSendingUser(int idSendingUser) {
		this.idSendingUser = idSendingUser;
	}
}
