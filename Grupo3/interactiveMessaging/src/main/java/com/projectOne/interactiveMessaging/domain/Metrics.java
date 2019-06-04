package com.projectOne.interactiveMessaging.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Metrics {
	
	private int id_Metrics;
	private int numberOfUsers;
	private int numberOfRooms;
	private float averageOfUsersPerRoom;
	private Timestamp dateLastMessage;
	private Timestamp dateFirstLogin;
	private String BigUser;
	private int numberMessagesBigUser;
	private String LongestMessage;
	private String LastRoomCreated;
	private String BiggestRoom;
	private int numberMessagesBiggestRoom;
	
	private int sumOfUsersPerGroup; //Esta variable no se debe de mostrar en el html
	private int quantityMessageBigUser;
	private static Metrics instance = new Metrics();//genera el Singlenton
	
	
	
	
//	public Metrics(int id_Metrics, int numberOfUsers, int numberOfRooms, float averageOfUsersPerRoom, Date dateLastMessage, Date dateFirstLogin,
//			int idBigUser, int numberMessagesBigUser, int idLongestMessage, int idLastRoomCreated,
//			int idBiggestRoom, int numberMessagesBiggestRoom) {
//		
//		if(numberOfUsers < 1) throw new RuntimeException("El numero de usuario es requerido.");
//		if(numberOfRooms < 1 || numberMessagesBigUser<1 || numberMessagesBiggestRoom<1) throw new RuntimeException("El numero de grupos es requerido.");
//		if(averageOfUsersPerRoom < 1) throw new RuntimeException("El porcentaje de usuarios es requerido.");
//		if(dateLastMessage == null ) throw new RuntimeException("La fecha de ultimo mensaje es requerida.");
//		if(dateFirstLogin == null ) throw new RuntimeException("La fecha del primer login es requerida.");
//		if(idBigUser < 1) throw new RuntimeException("El usuario con mas mensajes es requerido.");
//		if(idLongestMessage < 1) throw new RuntimeException("El mensaje mas largo es requerido.");
//		if(idLastRoomCreated < 1) throw new RuntimeException("El ultimo grupo creado es requerido.");
//		if(idBiggestRoom <1) throw new RuntimeException("El grupo con mas mensajes es requerido.");
//		
//		this.id_Metrics = id_Metrics;
//		this.numberOfUsers = numberOfUsers;
//		this.numberOfRooms = numberOfRooms;
//		this.averageOfUsersPerRoom = averageOfUsersPerRoom;
//		this.dateLastMessage = dateLastMessage;
//		this.dateFirstLogin = dateFirstLogin;
//		this.idBigUser = idBigUser;
//		this.numberMessagesBigUser=numberMessagesBigUser;
//		this.idLongestMessage = idLongestMessage;
//		this.idLastRoomCreated = idLastRoomCreated;
//		this.idBiggestRoom = idBiggestRoom;
//		this.numberMessagesBiggestRoom=numberMessagesBiggestRoom;
//	}
	
	public static Metrics getInstance() {
		return instance;
	}

	
	
	public boolean compareLongerMessage( String messageNew) {
		if(messageNew.length()> LongestMessage.length()) {
			return true;
		}
		return false;
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

	public Timestamp getDateLastMessage() {
		return dateLastMessage;
	}

	public void setDateLastMessage(Timestamp dateLastMessage) {
		this.dateLastMessage = dateLastMessage;
	}

	public Timestamp getDateFirstLogin() {
		return dateFirstLogin;
	}

	public void setDateFirstLogin(Timestamp dateFirstLogin) {
		this.dateFirstLogin = dateFirstLogin;
	}

	public String getBigUser() {
		return BigUser;
	}

	public void setBigUser(String BigUser) {
		this.BigUser = BigUser;
	}

	public int getNumberMessagesBigUser() {
		return numberMessagesBigUser;
	}

	public void setNumberMessagesBigUser(int numberMessagesBigUser) {
		this.numberMessagesBigUser = numberMessagesBigUser;
	}

	public String getLongestMessage() {
		return LongestMessage;
	}

	public void setLongestMessage(String LongestMessage) {
		this.LongestMessage = LongestMessage;
	}

	public String getLastRoomCreated() {
		return LastRoomCreated;
	}

	public void setLastRoomCreated(String LastRoomCreated) {
		this.LastRoomCreated = LastRoomCreated;
	}

	public String getBiggestRoom() {
		return BiggestRoom;
	}

	public void setBiggestRoom(String BiggestRoom) {
		this.BiggestRoom = BiggestRoom;
	}

	public int getNumberMessagesBiggestRoom() {
		return numberMessagesBiggestRoom;
	}

	public void setNumberMessagesBiggestRoom(int numberMessagesBiggestRoom) {
		this.numberMessagesBiggestRoom = numberMessagesBiggestRoom;
	}
	
	public int getSumOfUsersPerGroup() {
		return sumOfUsersPerGroup;
	}

	public void setSumOfUsersPerGroup(int sumOfUsersPerGroup) {
		this.sumOfUsersPerGroup = sumOfUsersPerGroup;
	}
	
	

	public int getQuantityMessageBigUser() {
		return quantityMessageBigUser;
	}



	public void setQuantityMessageBigUser(int quantityMessageBigUser) {
		this.quantityMessageBigUser = quantityMessageBigUser;
	}



	@Override
	public String toString() {
		return "Metrics [id_Metrics=" + id_Metrics + ", numberOfUsers=" + numberOfUsers + ", numberOfRooms="
				+ numberOfRooms + ", averageOfUsersPerRoom=" + averageOfUsersPerRoom + ", dateLastMessage="
				+ dateLastMessage + ", dateFirstLogin=" + dateFirstLogin + ", BigUser=" + BigUser
				+ ", numberMessagesBigUser=" + numberMessagesBigUser + ", LongestMessage=" + LongestMessage
				+ ", LastRoomCreated=" + LastRoomCreated + ", BiggestRoom=" + BiggestRoom
				+ ", numberMessagesBiggestRoom=" + numberMessagesBiggestRoom + ", sumOfUsersPerGroup="
				+ sumOfUsersPerGroup + "]";
	}



	public boolean compareUserMoreMessage(int numberMessages) {
		if(quantityMessageBigUser > numberMessages) {
			return true;
		}
		return false;
	}

	
	

}
