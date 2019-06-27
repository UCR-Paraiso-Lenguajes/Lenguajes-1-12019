package com.videocartago.renting.domain;

import java.util.LinkedList;
import java.util.List;

public class Productora {

	private static Productora productora;
	List<Object> contenido = new LinkedList<Object>();
	
	private Productora() {}
	
	public static Productora getProductora() {
		if(productora == null) {
			productora = new Productora();
		}
		return productora;
	}

	public List<Object> getContenido() {
		return contenido;
	}

	public void setContenido(List<Object> contenido) {
		this.contenido = contenido;
	}
	
	
}
