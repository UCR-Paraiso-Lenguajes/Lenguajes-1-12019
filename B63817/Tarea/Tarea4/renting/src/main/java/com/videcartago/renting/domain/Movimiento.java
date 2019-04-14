package com.videcartago.renting.domain;

import java.util.Date;

public class Movimiento {
	private Date fecha;
	private EstadoPelicula estadoPelicula;
	
	public Movimiento(Date fecha, EstadoPelicula estadoPelicula) {
		this.fecha = fecha;
		this.estadoPelicula = estadoPelicula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoPelicula getEstadoPelicula() {
		return estadoPelicula;
	}

	public void setEstadoPelicula(EstadoPelicula estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}
	
	

}
