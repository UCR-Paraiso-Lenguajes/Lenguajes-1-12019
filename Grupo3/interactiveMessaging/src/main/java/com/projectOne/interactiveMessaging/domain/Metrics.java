package com.orbis.B77436.domain;

import java.util.ArrayList;
import java.util.Date;

public class Metrics {
	
	private int numberOfUsers;
	private int numberOfRooms;
	private float averageUsers;
	private Date dateLastMessage;
	private Date dateFirstLogin;
	private String userWithManyMessage;
	private int numberOfUserWithManyMessage;
	private String longerMessage;
	private String lastRoomsCreate;
	private String roomWithMoreMessage;
	
	
	public boolean compareMetrics(Metrics metrics) {
		//falta logica
		return false;
	
	}
	
	public int compareNumberUsers(ArrayList<User> users) {
		//falta logica
		return 0;
		
	}
	
	public int compareAverageUsers(int averageActual, int averageNew) {
		//falta logica
		return 0;
	}
	
	public Date compareDateLastMessage(Date dateActual, Date dateNew) {
		//falta logica
		return dateFirstLogin;
		
	}
	
	public Date compareDateFirstLogin(Date dateLoginActual, Date dateLogin) {
		//falta logica
		return dateFirstLogin;
		
	}
	
	
	public Message compareLongerMessage(Message messageActual, Message messageNew) {
		//falta logica
		return null;
	}
	
	public Room compareRoomWithMoreMessage(ArrayList<Room> roomActual, ArrayList<Room>  roomNew) {
		//falta logica
		return null;
	}

}
