package com.videcartago.renting.domain;

import java.util.ArrayList;

public class User
{
	private int id;
	private String name;
	private String email;
	private String password;
	private ArrayList<Role> roles;
	
	public User(int id, String name, String email, String password, ArrayList<Role> roles) 
	{
		
		if(name == null || name.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
		if(email == null || email.trim().toLowerCase().equals("")) throw new RuntimeException("El email es requerido.");
		if(password == null || password.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
		if(roles == null || roles.size() == 0) throw new RuntimeException("El usuario debe tener al menos un rol.");
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getName() 
	{
		return name;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
	

}