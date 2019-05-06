package com.videcartago.renting.domain;

public class Contenido {
	private String duracion;
	private String descripcion;
	public Contenido(String duracion, String descripcion) {
		super();
		if (duracion !=null && descripcion!=null) {
			this.duracion = duracion;
			this.descripcion = descripcion;
		}else {
			throw new RuntimeException("El contenido no puede ser vacio");		
		}
		
	}
	

	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
}
