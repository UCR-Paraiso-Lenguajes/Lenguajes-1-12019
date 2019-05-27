package com.videocartago.renting.domain;

public class Genero {

	private int codGenero;
	private String nombreGenero;

	public Genero() {
		super();
	}
	public Genero(int codGenero, String nombreGenero) {
		if(codGenero!=0) 		
		this.codGenero = codGenero;
		if(nombreGenero!=null)
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
