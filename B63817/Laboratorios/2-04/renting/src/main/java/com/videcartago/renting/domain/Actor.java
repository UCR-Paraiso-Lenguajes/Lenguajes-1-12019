package com.videcartago.renting.domain;

public class Actor {
	private int codActor;
	private String nombreActor;
	private String apellidosActor;
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	

	public Actor(int codActor, String nombreActor, String apellidosActor) {
		this.codActor = codActor;
		this.nombreActor = nombreActor;
		this.apellidosActor = apellidosActor;
	}


	public int getCodActor() {
		return codActor;
	}

	public void setCodActor(int codActor) {
		this.codActor = codActor;
	}

	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public String getApellidosActor() {
		return apellidosActor;
	}

	public void setApellidosActor(String apellidosActor) {
		this.apellidosActor = apellidosActor;
	}
	
}