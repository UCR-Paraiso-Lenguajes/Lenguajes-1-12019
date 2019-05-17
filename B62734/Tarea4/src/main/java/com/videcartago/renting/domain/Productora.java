package com.videcartago.renting.domain;

import java.util.ArrayList;
import java.util.List;

public class Productora {
	private static Productora productora=new Productora();;
	private List<Contenido> contenidoProducido=new ArrayList<Contenido>();
	
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
