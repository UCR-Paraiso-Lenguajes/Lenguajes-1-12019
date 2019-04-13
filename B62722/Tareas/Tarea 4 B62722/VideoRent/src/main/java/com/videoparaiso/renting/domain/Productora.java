package com.videoparaiso.renting.domain;

import java.util.LinkedList;

public class Productora {
	
	private static Productora productora = new Productora();
	private LinkedList<Contenido> contenido;

	private Productora() {
		contenido = new LinkedList<Contenido>();
	}

	public static Productora getProductora() {
		return productora;
	}

	public LinkedList<Contenido> getContenido() {
		return contenido;
	}

	public void setContenido(LinkedList<Contenido> contenido) {
		this.contenido = contenido;
	}
}
