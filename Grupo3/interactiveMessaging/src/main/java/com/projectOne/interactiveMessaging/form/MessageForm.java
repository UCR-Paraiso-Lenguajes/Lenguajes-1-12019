package com.projectOne.interactiveMessaging.form;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.projectOne.interactiveMessaging.domain.User;

public class MessageForm {
	@NotNull
	private int message_id;
	@NotNull
	@Size(min=1, max=500)
	private String message;
	@NotNull
	@Valid
	private User userTransmitter;
	@NotNull
	@Past //Utilizo past como posible opcion para indicar que la fecha no puede ser posterior a la de envio
	private Date dateMessage;
	
	public MessageForm() {
		super();
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUserTransmitter() {
		return userTransmitter;
	}

	public void setUserTransmitter(User userTransmitter) {
		this.userTransmitter = userTransmitter;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}
	
	

}
