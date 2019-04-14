package com.videocartago.renting.domain;


public class Movimientos {
	
	private String fechaMovimiento;
	private String estado;
	private Pelicula pelicula;
	
	public Movimientos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movimientos(String fechaMovimiento, String estado, Pelicula pelicula) {
		super();
		this.fechaMovimiento = fechaMovimiento;
		this.estado = estado;
		this.pelicula = pelicula;
	}

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Movimientos [fechaMovimiento=" + fechaMovimiento + ", estado=" + estado + ", pelicula=" + pelicula
				+ "]";
	}
	
	

}
