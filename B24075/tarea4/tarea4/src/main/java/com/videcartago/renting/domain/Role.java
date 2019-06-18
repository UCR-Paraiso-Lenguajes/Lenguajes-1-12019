package com.videcartago.renting.domain;

public class Role {
	private int id;
	private String name;
	
	public Role(int id, String name) 
	{
		if(name == null || name.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
	
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}	
	
	
	
}