package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.RolException;

public class Rol {
	private int rolid;
	private String nombre;
	
	
	public Rol() {
		super();
	}


	public Rol(int rollid, String nombre) throws RolException {
		super();
		if (nombre==null) {
		throw new RolException("el rol esta vacio");
		}
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
