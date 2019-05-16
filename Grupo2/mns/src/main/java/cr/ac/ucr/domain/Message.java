package cr.ac.ucr.domain;

import java.util.Date;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Message {

	private int id;
	private String content;
	private	User messageSender;
	private Room roomWhereThisMessageBelong;
	private Date date;
	
	public Message(String content) 
	{
		validMessage(content);
		this.date = new Date();
	}

	public Message() {
	}

	private void validMessage(String content) {
		if(content == null ||content.trim().equals("") ) throw new ProjectExceptions("El mensaje no puede estar vacío");		
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	Room getRoomWhereThisMessageBelongs() 
	{
		return roomWhereThisMessageBelong;
	}
	
	void setRoomWhereThisMessageBelongs(Room roomWhereThisMessageBelong) 
	{
		if(roomWhereThisMessageBelong == null  ) throw new ProjectExceptions("El grupo debe existir");		
		this.roomWhereThisMessageBelong = roomWhereThisMessageBelong;
	}

	Date getDate() 
	{
		return date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(User messageSender) {
		if(messageSender == null  ) throw new ProjectExceptions("El usuario debe existir");		
		this.messageSender = messageSender;
	}
	
}
