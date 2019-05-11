package com.projectOne.interactiveMessaging.domain;

import java.util.Date;
import java.util.Iterator;

public class Message {
	
	private int message_id;
	private String message;
	private User userTransmitter;
	private Date dateMessage;
	
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
	
	public Iterator extractMessage(int id_room) {
		//TODO falta logica
		return null;
	}
	
}
