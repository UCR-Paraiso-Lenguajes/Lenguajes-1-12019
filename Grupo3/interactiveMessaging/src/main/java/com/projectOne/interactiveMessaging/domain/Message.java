package com.projectOne.interactiveMessaging.domain;

import java.util.Date;
import java.util.Iterator;

public class Message {
	
	private int message_id;
	private String message;
	private User userTransmitter;
	private Date dateMessage;
	
	public Message(int message_id, String message, User userTransmitter, Date dateMessage) {
		super();
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
