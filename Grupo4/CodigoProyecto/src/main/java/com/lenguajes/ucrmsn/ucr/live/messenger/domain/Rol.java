package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

public class Rol {
	private int rolid;
	private String nombre;
	
	
	public Rol() {
		super();
	}


	public Rol(int rollid, String nombre) {
		super();
		this.rolid = rollid;
		this.nombre = nombre;
	}


	public int getRolid() {
		return rolid;
	}


	public void setRolid(int rollid) {
		this.rolid = rollid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
