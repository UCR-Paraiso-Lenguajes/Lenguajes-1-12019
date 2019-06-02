package com.videocartago.renting.domain;

public class Genero {
	private String nombreGenero;
	private int codGenero;
	public String getNombreGenero() {
		return nombreGenero;
	}
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	public int getCodGenero() {
		return codGenero;
	}
	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}
	public Genero(int codGenero,String nombreGenero) {
		this.nombreGenero = nombreGenero;
		this.codGenero = codGenero;
	}
	
}
