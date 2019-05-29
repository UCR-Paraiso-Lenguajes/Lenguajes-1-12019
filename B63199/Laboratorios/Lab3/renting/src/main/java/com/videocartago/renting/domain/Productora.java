package com.videocartago.renting.domain;

import java.util.Iterator;

public class Productora {

	private int codProductora;
	private String nombreProductora;
	private Iterator<Object> contenido;//puede creae videos, clips y peliculas
	
	public Productora(int codProductora, String nombreProductora, Iterator<Object> contenido) {
		super();
		this.codProductora = codProductora;
		this.nombreProductora = nombreProductora;
		this.contenido = contenido;
	}
	
	public int getCodProductora() {
		return codProductora;
	}
	public void setCodProductora(int codProductora) {
		this.codProductora = codProductora;
	}
	public String getNombreProductora() {
		return nombreProductora;
	}
	public void setNombreProductora(String nombreProductora) {
		this.nombreProductora = nombreProductora;
	}
	public Iterator<Object> getContenido() {
		return contenido;
	}
	public void setContenido(Iterator<Object> contenido) {
		this.contenido = contenido;
	}
	
	
	
	
}



