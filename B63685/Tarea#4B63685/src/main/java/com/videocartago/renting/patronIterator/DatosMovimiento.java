package com.videocartago.renting.patronIterator;

import java.util.ArrayList;

public class DatosMovimiento {
	
	private String fechaMovimiento;
	private String registroEstadoPelicula;
	
	
	public DatosMovimiento(String fechaMovimiento, String registroEstadoPelicula) {
		super();
		this.fechaMovimiento = fechaMovimiento;
		this.registroEstadoPelicula = registroEstadoPelicula;
	}
	
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public String getRegistroEstadoPelicula() {
		return registroEstadoPelicula;
	}
	public void setRegistroEstadoPelicula(String registroEstadoPelicula) {
		this.registroEstadoPelicula = registroEstadoPelicula;
	}	
	
	
	

}
