package com.videocartago.renting.domain;

import java.util.Date;

public class Movimientos {

	private Date fecha;
	private String estado;
	private int codPelicula;
	private String titulo;
	
	public Movimientos() {
		super();
	}

	public Movimientos(Date fecha, String estado, int codPelicula, String titulo) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.codPelicula = codPelicula;
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
}
