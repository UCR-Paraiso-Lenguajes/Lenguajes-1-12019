package com.videocartago.renting.domain;

public class Genero {
	private int codGenero;
	private String nombreGenero;
	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(int codGenero, String nombreGenero) {
		if(codGenero==0) throw new RuntimeException("El codigo genero no puede venir vacio");
		if(nombreGenero.equals("")) throw new RuntimeException("El nombre genero no puede venir vacío");
		this.codGenero = codGenero;
		this.nombreGenero = nombreGenero;
	}

	public int getCodGenero() {
		return codGenero;
	}
	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}
	public String getNombreGenero() {
		return nombreGenero;
	}
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
}
