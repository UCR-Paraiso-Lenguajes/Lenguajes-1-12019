package com.chat.domain;

import java.sql.Date;

public class Message {
	
	private int id;
	private String message;
	private Date dateTime;

	public Message(int id, String message, Date dateTime) {
		super();
		if (id < 0)
			throw new RuntimeException("El id del mensaje debe ser mayor  0.");
		if (message == null || message.trim().equals(""))
			throw new RuntimeException("El mensaje es requerida es requerido");
		this.id = id;
		this.message = message;
		this.dateTime = dateTime;
	}

	public Message() {
		super();
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", dateTime=" + dateTime + "]";
	}

}
package com.chat.domain;

public class Message {
	private int id;
	private String message;
	private String date;
	private int idSendingUser;
	
	public Message(int id, String message, String date, int idSendingUser) {
		super();
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
