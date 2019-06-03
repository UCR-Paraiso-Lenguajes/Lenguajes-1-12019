package com.proyectoUno.grupo5.domain;

import java.util.Date;

public class Metrics {
	
	private int idmetrics;
	private int quantityOfRooms;
	private int quantityOfUsers;
	private int averageUsersForRooms;
	private String last_message;
	private Date first_login;
	private Date date_first_login;
	private int user_with_more_message;
	private String last_group_created;
	private String group_with_more_message;
	

	
	

	public String getLast_message() {
		return last_message;
	}


	public void setLast_message(String last_message) {
		this.last_message = last_message;
	}


	public Date getFirst_login() {
		return first_login;
	}


	public void setFirst_login(Date first_login) {
		this.first_login = first_login;
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


	public Metrics() {
		super();
	}


	public int getQuantityOfRooms() {
		return quantityOfRooms;
	}


	public void setQuantityOfRooms(int quantityOfRooms) {
		this.quantityOfRooms = quantityOfRooms;
	}


	public int getIdmetrics() {
		return idmetrics;
	}


	public void setIdmetrics(int idmetrics) {
		this.idmetrics = idmetrics;
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


	public Metrics(int idmetrics, int quantityOfRooms, int quantityOfUsers, int averageUsersForRooms,
			String last_message, Date first_login, Date date_first_login, int user_with_more_message,
			String last_group_created, String group_with_more_message) {
		super();
		this.idmetrics = idmetrics;
		this.quantityOfRooms = quantityOfRooms;
		this.quantityOfUsers = quantityOfUsers;
		this.averageUsersForRooms = averageUsersForRooms;
		this.last_message = last_message;
		this.first_login = first_login;
		this.date_first_login = date_first_login;
		this.user_with_more_message = user_with_more_message;
		this.last_group_created = last_group_created;
		this.group_with_more_message = group_with_more_message;
	}


	
	
	

}
