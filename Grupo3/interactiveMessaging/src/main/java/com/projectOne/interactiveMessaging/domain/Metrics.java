package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.Date;

public class Metrics {
	
	private int id_Metrics;
	private int numberOfUsers;
	private int numberOfRooms;
	private float averageOfUsersPerRoom;
	private Date dateLastMessage;
	private Date dateFirstLogin;
	private int idBigUser;
	private int idLongestMessage;
	private int idLastRoomCreated;
	private int idBiggestRoom;
	
	
	
	
	public Metrics(int id_Metrics, int numberOfUsers, int numberOfRooms, float averageOfUsersPerRoom, Date dateLastMessage, Date dateFirstLogin,
			int idBigUser, int idLongestMessage, int idLastRoomCreated,
			int idBiggestRoom) {
		
		if(numberOfUsers < 1) throw new RuntimeException("El numero de usuario es requerido.");
		if(numberOfRooms < 1) throw new RuntimeException("El numero de grupos es requerido.");
		if(averageOfUsersPerRoom < 1) throw new RuntimeException("El porcentaje de usuarios es requerido.");
		if(dateLastMessage == null ) throw new RuntimeException("La fecha de ultimo mensaje es requerida.");
		if(dateFirstLogin == null ) throw new RuntimeException("La fecha del primer login es requerida.");
		if(idBigUser < 1) throw new RuntimeException("El usuario con mas mensajes es requerido.");
		if(idLongestMessage < 1) throw new RuntimeException("El mensaje mas largo es requerido.");
		if(idLastRoomCreated < 1) throw new RuntimeException("El ultimo grupo creado es requerido.");
		if(idBiggestRoom <1) throw new RuntimeException("El grupo con mas mensajes es requerido.");
		
		this.id_Metrics = id_Metrics;
		this.numberOfUsers = numberOfUsers;
		this.numberOfRooms = numberOfRooms;
		this.averageOfUsersPerRoom = averageOfUsersPerRoom;
		this.dateLastMessage = dateLastMessage;
		this.dateFirstLogin = dateFirstLogin;
		this.idBigUser = idBigUser;
		this.idLongestMessage = idLongestMessage;
		this.idLastRoomCreated = idLastRoomCreated;
		this.idBiggestRoom = idBiggestRoom;
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
