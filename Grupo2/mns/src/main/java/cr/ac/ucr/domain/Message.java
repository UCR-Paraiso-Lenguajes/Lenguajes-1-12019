package cr.ac.ucr.domain;

import java.util.Date;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Message {

	private int id;
	private String content;
	private Room roomWhereThisMessageBelong;
	private Date date;
	
	public Message(String content) 
	{
		validMessage(content);
		this.date = new Date();
	}

	public Message() {
		// TODO Auto-generated constructor stub
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
		//TODO vdalidaciones
		this.roomWhereThisMessageBelong = roomWhereThisMessageBelong;
	}

	Date getDate() 
	{
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
