package com.videoparaiso.renting.domain;

import java.util.LinkedList;

public class Productora {
	private static Productora productora;
	private LinkedList<Contenido> contenidoProducido = new LinkedList<Contenido>();
	
	private Productora() {
		productora = new Productora();
		contenidoProducido = new LinkedList<Contenido>();
	}
	
	public boolean registrarContenido(Contenido contenidoNuevo)
	{
		boolean registradoCorrectamente = false;
		
		if(contenidoNuevo !=null && !contenidoProducido.contains(contenidoNuevo)) {
			contenidoProducido.add(contenidoNuevo);
			registradoCorrectamente = true;
		} else {
			throw new RuntimeException("El contenido no pudo ser agregado."); 
		}
		return registradoCorrectamente;
	}
		public static Productora getProductora() {
		return productora;
	}
	public LinkedList<Contenido> getContenido() {
		return contenidoProducido;
	}
	public void setContenido(LinkedList<Contenido> contenido) {
		this.contenidoProducido = contenido;
	}
	public static void setProductora(Productora productora) {
		Productora.productora = productora;
	}
}
