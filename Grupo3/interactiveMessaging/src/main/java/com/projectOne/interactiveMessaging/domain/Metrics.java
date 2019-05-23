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
	private int numberMessagesBigUser;
	private int idLongestMessage;
	private int idLastRoomCreated;
	private int idBiggestRoom;
	private int numberMessagesBiggestRoom;
	
	
	
	
	public Metrics(int id_Metrics, int numberOfUsers, int numberOfRooms, float averageOfUsersPerRoom, Date dateLastMessage, Date dateFirstLogin,
			int idBigUser, int numberMessagesBigUser, int idLongestMessage, int idLastRoomCreated,
			int idBiggestRoom, int numberMessagesBiggestRoom) {
		
		if(numberOfUsers < 1) throw new RuntimeException("El numero de usuario es requerido.");
		if(numberOfRooms < 1 || numberMessagesBigUser<1 || numberMessagesBiggestRoom<1) throw new RuntimeException("El numero de grupos es requerido.");
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
		this.numberMessagesBigUser=numberMessagesBigUser;
		this.idLongestMessage = idLongestMessage;
		this.idLastRoomCreated = idLastRoomCreated;
		this.idBiggestRoom = idBiggestRoom;
		this.numberMessagesBiggestRoom=numberMessagesBiggestRoom;
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

	public int getId_Metrics() {
		return id_Metrics;
	}

	public void setId_Metrics(int id_Metrics) {
		this.id_Metrics = id_Metrics;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public float getAverageOfUsersPerRoom() {
		return averageOfUsersPerRoom;
	}

	public void setAverageOfUsersPerRoom(float averageOfUsersPerRoom) {
		this.averageOfUsersPerRoom = averageOfUsersPerRoom;
	}

	public Date getDateLastMessage() {
		return dateLastMessage;
	}

	public void setDateLastMessage(Date dateLastMessage) {
		this.dateLastMessage = dateLastMessage;
	}

	public Date getDateFirstLogin() {
		return dateFirstLogin;
	}

	public void setDateFirstLogin(Date dateFirstLogin) {
		this.dateFirstLogin = dateFirstLogin;
	}

	public int getIdBigUser() {
		return idBigUser;
	}

	public void setIdBigUser(int idBigUser) {
		this.idBigUser = idBigUser;
	}

	public int getNumberMessagesBigUser() {
		return numberMessagesBigUser;
	}

	public void setNumberMessagesBigUser(int numberMessagesBigUser) {
		this.numberMessagesBigUser = numberMessagesBigUser;
	}

	public int getIdLongestMessage() {
		return idLongestMessage;
	}

	public void setIdLongestMessage(int idLongestMessage) {
		this.idLongestMessage = idLongestMessage;
	}

	public int getIdLastRoomCreated() {
		return idLastRoomCreated;
	}

	public void setIdLastRoomCreated(int idLastRoomCreated) {
		this.idLastRoomCreated = idLastRoomCreated;
	}

	public int getIdBiggestRoom() {
		return idBiggestRoom;
	}

	public void setIdBiggestRoom(int idBiggestRoom) {
		this.idBiggestRoom = idBiggestRoom;
	}

	public int getNumberMessagesBiggestRoom() {
		return numberMessagesBiggestRoom;
	}

	public void setNumberMessagesBiggestRoom(int numberMessagesBiggestRoom) {
		this.numberMessagesBiggestRoom = numberMessagesBiggestRoom;
	}
	
	

}
