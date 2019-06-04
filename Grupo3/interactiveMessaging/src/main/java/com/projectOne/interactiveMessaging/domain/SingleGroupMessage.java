package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;

public class SingleGroupMessage {
	private int idGroup;
	private Message message;
	private ArrayList<Integer> usersIDs;
	
	public ArrayList<Integer> getUsersIDs() {
		return usersIDs;
	}

	public void setUsersIDs(ArrayList<Integer> usersIDs) {
		this.usersIDs = usersIDs;
	}

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
