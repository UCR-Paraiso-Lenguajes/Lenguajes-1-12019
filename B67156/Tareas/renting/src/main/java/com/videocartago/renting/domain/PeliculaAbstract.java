package com.videocartago.renting.domain;

public abstract class PeliculaAbstract {
	
	private String estadoString;
	private Estado estado;
	
	
	public PeliculaAbstract() {
		super();
	}
	
	public PeliculaAbstract(String estado) {
		super();
		this.estadoString = estado;
	}
	

	public String getEstadoString() {
		return estadoString;
	}

	public void setEstadoString(String estadoString) {
		this.estadoString = estadoString;
	}

	public void difineEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado.EstadoEnum Rentar() {
		return estado.definirEstado();
	}

	@Override
	public String toString() {
		return "Estado Pelicula [estado = " + estadoString ;
	}
	
	
}
