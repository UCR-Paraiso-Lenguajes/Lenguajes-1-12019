package com.videcartago.renting.domain;

import java.util.Date;

public class Movimiento  {
	private Date fecha;
	private String nombrePelicula;
	private EstadoPelicula estado;
	
	public Movimiento(Date fecha, String nombrePelicula, EstadoPelicula estado) {
		super();
		this.fecha = fecha;
		this.nombrePelicula = nombrePelicula;
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	public EstadoPelicula getEstado() {
		return estado;
	}
	public void setEstado(EstadoPelicula estado) {
		this.estado = estado;
	}	
}
