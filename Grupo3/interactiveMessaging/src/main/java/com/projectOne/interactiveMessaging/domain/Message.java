package com.projectOne.interactiveMessaging.domain;

import java.util.Date;
import java.util.Iterator;

public class Message {
	
	private int message_id;
	private String message;
	private User userTransmitter;
	private Date dateMessage;
	private int sizeOfMessage;
	public Message(int message_id, String message, User userTransmitter, Date dateMessage) {
		
		if(message == null || message.trim().toLowerCase().equals("")) throw new RuntimeException("El mensaje es requerido");
		if(dateMessage == null || dateMessage.before(new Date())) throw new RuntimeException
		("La fecha es requerida o corresponde a una fecha erronea."); //La fecha que ingresa debe ser inferior a la actual
		if(userTransmitter == null) throw new RuntimeException("El usuario es requerido.");
		this.message_id = message_id;
		this.message = message;
		this.userTransmitter = userTransmitter;
		this.dateMessage = dateMessage;
	}
	
	public Message(int message_id, String message, Date dateMessage, int sizeOfMessage) {
		if(message == null || message.trim().toLowerCase().equals("")) throw new RuntimeException("El mensaje es requerido");
		if(dateMessage == null || dateMessage.before(new Date())) throw new RuntimeException
		("La fecha es requerida o corresponde a una fecha erronea."); //La fecha que ingresa debe ser inferior a la actual
		this.message_id = message_id;
		this.message = message;
		this.dateMessage = dateMessage;
		this.sizeOfMessage = sizeOfMessage;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage() {
		if(message == null || message.trim().toLowerCase().equals("")) throw new RuntimeException("El mensaje es requerido");
		return message;
	}

	public void setMessage(String message) {
		if(message == null || message.trim().toLowerCase().equals("")) throw new RuntimeException("El mensaje es requerido");
		this.message = message;
	}

	public User getUserTransmitter() {
		if(userTransmitter == null) throw new RuntimeException("El usuario es requerido.");
		return userTransmitter;
	}

	public void setUserTransmitter(User userTransmitter) {
		if(userTransmitter == null) throw new RuntimeException("El usuario es requerido.");
		this.userTransmitter = userTransmitter;
	}

	public Date getDateMessage() {
		if(dateMessage == null || dateMessage.before(new Date())) throw new RuntimeException("La fecha es requerida o corresponde a una fecha erronea.");;
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		if(dateMessage == null || dateMessage.before(new Date())) throw new RuntimeException("La fecha es requerida o corresponde a una fecha erronea.");
		this.dateMessage = dateMessage;
	}

	public int getSizeOfMessage() {
		return sizeOfMessage;
	}

	public void setSizeOfMessage(int sizeOfMessage) {
		this.sizeOfMessage = sizeOfMessage;
	}

	public Iterator extractMessage(int id_room) {
		//TODO falta logica
		return null;
	}
	
}
