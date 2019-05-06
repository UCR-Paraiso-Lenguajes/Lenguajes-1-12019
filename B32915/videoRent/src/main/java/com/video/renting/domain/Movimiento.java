package com.video.renting.domain;

import java.util.Date;
import java.util.Iterator;

public class Movimiento {
	
	private int id;
	private Date fechaMovimiento;
	private boolean estado;
	private Pelicula peli;
	private Iterator<Movimiento> iteratorMovimientos;
	
	

	public Movimiento(int id, Date fechaMovimiento, boolean estado, Pelicula peli) {
		this.id = id;
		this.fechaMovimiento = fechaMovimiento;
		this.estado = estado;
		this.peli = peli;
	}

	public Pelicula getPeli() {
		return peli;
	}

	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}

	public Iterator<Movimiento> MovimientoIterator() {
		
		return iteratorMovimientos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
