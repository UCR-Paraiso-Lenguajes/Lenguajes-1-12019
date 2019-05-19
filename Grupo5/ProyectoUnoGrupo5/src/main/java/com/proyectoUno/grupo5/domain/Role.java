package com.proyectoUno.grupo5.domain;

public class Role {
	
	
	private int idRole;
	private String roleType;
	
	
	public Role(int idRole, String roleType) {
		super();
		this.idRole = idRole;
		this.roleType = roleType;
	}
	public Role(){

	}

	public int getIdRole() {
		return idRole;
	}


	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	public String getRoleType() {
		return roleType;
	}


	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
	

}
