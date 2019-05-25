package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

public class Rol {
	private int rollid;
	private String nombre;
	
	
	public Rol() {
		super();
	}


	public Rol(int rollid, String nombre) {
		super();
		this.rollid = rollid;
		this.nombre = nombre;
	}


	public int getRollid() {
		return rollid;
	}


	public void setRollid(int rollid) {
		this.rollid = rollid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
