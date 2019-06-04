package com.proyectoUno.grupo5.domain;

import java.util.Date;

public class Metrics {
	
	private int idmetrics;
	private int quantityOfRooms;
	private int quantityOfUsers;
	private int averageUsersForRooms;
	private Date date_last_message;
	private Date date_first_login;
	private int user_with_more_message;
	private int quantityOfMessageUser;
	private String message;
	private String last_group_created;
	private String group_with_more_message;
	private int quantityOfMessageRoom;
	
	
	
	
	
	public Metrics(int idmetrics, int quantityOfRooms, int quantityOfUsers, int averageUsersForRooms,
			Date date_last_message, Date date_first_login, int user_with_more_message, int quantityOfMessageUser,
			String message, String last_group_created, String group_with_more_message, int quantityOfMessageRoom) {
		super();
		this.idmetrics = idmetrics;
		this.quantityOfRooms = quantityOfRooms;
		this.quantityOfUsers = quantityOfUsers;
		this.averageUsersForRooms = averageUsersForRooms;
		this.date_last_message = date_last_message;
		this.date_first_login = date_first_login;
		this.user_with_more_message = user_with_more_message;
		this.quantityOfMessageUser = quantityOfMessageUser;
		this.message = message;
		this.last_group_created = last_group_created;
		this.group_with_more_message = group_with_more_message;
		this.quantityOfMessageRoom = quantityOfMessageRoom;
	}
	
	
	
	
	public Metrics() {
		super();
	}




	public int getIdmetrics() {
		return idmetrics;
	}
	public void setIdmetrics(int idmetrics) {
		this.idmetrics = idmetrics;
	}
	public int getQuantityOfRooms() {
		return quantityOfRooms;
	}
	public void setQuantityOfRooms(int quantityOfRooms) {
		this.quantityOfRooms = quantityOfRooms;
	}
	public int getQuantityOfUsers() {
		return quantityOfUsers;
	}
	public void setQuantityOfUsers(int quantityOfUsers) {
		this.quantityOfUsers = quantityOfUsers;
	}
	public int getAverageUsersForRooms() {
		return averageUsersForRooms;
	}
	public void setAverageUsersForRooms(int averageUsersForRooms) {
		this.averageUsersForRooms = averageUsersForRooms;
	}
	public Date getDate_last_message() {
		return date_last_message;
	}
	public void setDate_last_message(Date date_last_message) {
		this.date_last_message = date_last_message;
	}
	public Date getDate_first_login() {
		return date_first_login;
	}
	public void setDate_first_login(Date date_first_login) {
		this.date_first_login = date_first_login;
	}
	public int getUser_with_more_message() {
		return user_with_more_message;
	}
	public void setUser_with_more_message(int user_with_more_message) {
		this.user_with_more_message = user_with_more_message;
	}
	public int getQuantityOfMessageUser() {
		return quantityOfMessageUser;
	}
	public void setQuantityOfMessageUser(int quantityOfMessageUser) {
		this.quantityOfMessageUser = quantityOfMessageUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLast_group_created() {
		return last_group_created;
	}
	public void setLast_group_created(String last_group_created) {
		this.last_group_created = last_group_created;
	}
	public String getGroup_with_more_message() {
		return group_with_more_message;
	}
	public void setGroup_with_more_message(String group_with_more_message) {
		this.group_with_more_message = group_with_more_message;
	}
	public int getQuantityOfMessageRoom() {
		return quantityOfMessageRoom;
	}
	public void setQuantityOfMessageRoom(int quantityOfMessageRoom) {
		this.quantityOfMessageRoom = quantityOfMessageRoom;
	}
	

	
	

	
	
	

}
