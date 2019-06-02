package com.proyectoUno.grupo5.domain;

public class Admin {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin() {
		super();
		this.username = "admin";
		this.password = "123456";
	}
	
	
	
}
