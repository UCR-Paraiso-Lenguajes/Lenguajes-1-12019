package com.videocartago.renting.domain;

import java.util.Date;

public class Movimiento {

	private int codMovimiento;
	private String estado;
	private Date fechaActual;
	private Pelicula pelicula;
	public Movimiento(Object pelicula, String estado) {
		this.pelicula = (Pelicula) pelicula;
		this.estado = estado;
			}
	public Movimiento() {
		
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public int getCodMovimiento() {
		return codMovimiento;
	}
	public void setCodMovimiento(int codMovimiento) {
		this.codMovimiento = codMovimiento;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
	
}
