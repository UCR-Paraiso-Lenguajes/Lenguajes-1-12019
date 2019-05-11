package com.projectOne.interactiveMessaging.domain;

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
	
	
	
	
	public Metrics(int numberOfUsers, int numberOfRooms, float averageUsers, Date dateLastMessage, Date dateFirstLogin,
			String userWithManyMessage, int numberOfUserWithManyMessage, String longerMessage, String lastRoomsCreate,
			String roomWithMoreMessage) {
		
		if(numberOfUsers < 1) throw new RuntimeException("El numero de usuario es requerido.");
		if(numberOfRooms < 1) throw new RuntimeException("El numero de grupos es requerido.");
		if(averageUsers < 1) throw new RuntimeException("El porcentaje de usuarios es requerido.");
		if(dateLastMessage == null ) throw new RuntimeException("La fecha de ultimo mensaje es requerida.");
		if(dateFirstLogin == null ) throw new RuntimeException("La fecha del primer login es requerida.");
		if(userWithManyMessage == null || userWithManyMessage.trim().toLowerCase().equals("")) 
			throw new RuntimeException("El usuario con mas mensajes es requerido.");
		if(longerMessage == null || longerMessage.trim().toLowerCase().equals("")) 
			throw new RuntimeException("El mensaje mas largo es requerido.");
		if(lastRoomsCreate == null || lastRoomsCreate.trim().toLowerCase().equals("")) 
			throw new RuntimeException("El ultimo grupo creado es requerido.");
		if(roomWithMoreMessage == null || roomWithMoreMessage.trim().toLowerCase().equals("")) 
			throw new RuntimeException("El grupo con mas mensajes es requerido.");
		
		this.numberOfUsers = numberOfUsers;
		this.numberOfRooms = numberOfRooms;
		this.averageUsers = averageUsers;
		this.dateLastMessage = dateLastMessage;
		this.dateFirstLogin = dateFirstLogin;
		this.userWithManyMessage = userWithManyMessage;
		this.numberOfUserWithManyMessage = numberOfUserWithManyMessage;
		this.longerMessage = longerMessage;
		this.lastRoomsCreate = lastRoomsCreate;
		this.roomWithMoreMessage = roomWithMoreMessage;
	}

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
