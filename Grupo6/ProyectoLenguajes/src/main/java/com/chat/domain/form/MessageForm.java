package com.chat.domain.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageForm {

	@NotNull
	@Size(min=1, max=500)
	private int id;
	@NotNull
	private String message;
	@NotNull
	private String date;
	@NotNull
	@Size(min=1, max=500)
	private int idSendingUser;
	public MessageForm() {
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
	@Override
	public String toString() {
		return "MessageForm [id=" + id + ", message=" + message + ", date=" + date + ", idSendingUser=" + idSendingUser
				+ "]";
	}
	
}
