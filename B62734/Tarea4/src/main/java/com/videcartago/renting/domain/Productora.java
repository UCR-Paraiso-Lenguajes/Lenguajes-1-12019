package com.videcartago.renting.domain;

import java.util.LinkedList;

public class Productora {
	private static Productora productora=new Productora();;
	private LinkedList<Contenido> contenidoProducido=new LinkedList<Contenido>();
	
	public static Productora getProductora() {
		return productora;
	}
	public boolean agregarContenido(Contenido contenido) {
		boolean seAgrego=false;
		if (contenido!=null && !contenidoProducido.contains(contenido) ) {
			contenidoProducido.add(contenido);
			seAgrego=true;
		}else {
			throw new RuntimeException("El contenido no puede ser agregado");		
		}
		return seAgrego;
	}
}
