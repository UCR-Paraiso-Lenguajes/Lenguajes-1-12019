package com.videocartago.renting.domain;

public class Genero {
	private int codGenero;
	private String nombreGenero;
	
	public Genero(int codGenero, String nombreGenero) {
		if(codGenero <= 0) throw new RuntimeException("El código no puede ser 0 o negativo");
		this.codGenero = codGenero;
		if(nombreGenero.equals("") || nombreGenero == null ) throw new RuntimeException("El nombre no puede ser nulo");
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
