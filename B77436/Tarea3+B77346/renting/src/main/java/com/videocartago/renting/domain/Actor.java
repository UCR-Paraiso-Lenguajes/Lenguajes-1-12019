package com.videocartago.renting.domain;

public class Actor {
	private int codActor;
	private String nombreActor;
	private String apellidosActor;
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	

	public Actor(int codActor, String nombreActor, String apellidosActor) {
		if(codActor==0) throw new RuntimeException("El codigo actor no puede venir sin valor");
		if(nombreActor.equals("") || apellidosActor.equals("")) throw new RuntimeException("Los campos no pueden venir vacios");
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