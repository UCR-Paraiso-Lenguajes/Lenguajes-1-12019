package com.projectOne.interactiveMessaging.domain;

public class Role {
	
	private int role_id;
	private String name_Role;
	
	public Role(int role_id, String name_Role) {
		
		if(name_Role == null || name_Role.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
		this.role_id = role_id;
		this.name_Role = name_Role;
	}

	public Role() {
		super();
	}

	public String getName_Role() {
		return name_Role;
	}

	public void setName_Role(String name_Role) {
		this.name_Role = name_Role;
	}
	

}
