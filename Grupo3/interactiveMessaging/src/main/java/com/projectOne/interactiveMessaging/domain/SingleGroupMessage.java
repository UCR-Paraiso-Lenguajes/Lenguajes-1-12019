package com.projectOne.interactiveMessaging.domain;

public class SingleGroupMessage {
	private int idGroup;
	private Message message;
	
	public SingleGroupMessage(int idGroup, Message message) {
		setIdGroup(idGroup);
		setMessage(message);
	}
	
	public SingleGroupMessage() {
	}

	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		if(idGroup==0) {
			throw new RuntimeException("idGroup esta vacio");
		}
		this.idGroup = idGroup;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		if(message==null||message.getUserTransmitter()==null) {
			throw new RuntimeException("message o el usuario estan nulos ");
		}
		this.message = message;
	}
	
}
