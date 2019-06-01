package com.videocartago.renting.domain;

public class Productora {
	private static Productora instancia;
	private static PeliculaFactory peliculaFactory;

	private Productora() {
	}
	
	
	public static Productora getInstancia() {
		if(instancia == null) {
			instancia = new Productora();
		}
		return instancia; 
	}
	
	public void crearContenido(Object obj) {
		if(obj == null) throw new RuntimeException("El objeto no puede ser nulo");
		if(obj instanceof Pelicula) {
			peliculaFactory.crearPelicula((Pelicula)obj);
		}
		else if(obj instanceof Video) {
			//crea video
		}
		else if(obj instanceof Clip) {
			//crea clip
		}else {
			throw new RuntimeException("No se puede crear por tipo de objeto invalido o nulo");
		}
			
	}
	
}
