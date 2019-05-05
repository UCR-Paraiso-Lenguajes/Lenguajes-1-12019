package com.videocartago.renting.domain;

public class Genero {
	
	private int codGenero;
	private String nombreGenero;
	private EnumGenero enumGenero;
	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(int codGenero, String nombreGenero, EnumGenero enumGenero) {
		this.codGenero = codGenero;
		this.nombreGenero = nombreGenero;
		this.enumGenero = enumGenero;
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
	
	public EnumGenero getEnumGenero() {
		return enumGenero;
	}

	public void setEnumGenero(EnumGenero enumGenero) {
		this.enumGenero = enumGenero;
	}

	@Override
	public String toString() {
		return "Genero [codGenero=" + codGenero + ", nombreGenero=" + nombreGenero + "]";
	}
	
	

}
