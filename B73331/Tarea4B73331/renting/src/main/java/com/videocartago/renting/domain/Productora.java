package com.videocartago.renting.domain;

public class Productora {
	private static Productora instance= new Productora();
	private String contenido = "";
	public Productora() {
		
	}
	public static Productora getInstance(){
        return instance;
    }
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		if(!contenido.equalsIgnoreCase("videos")&&!contenido.equalsIgnoreCase("clips")&&!contenido.equalsIgnoreCase("peliculas")) {
			throw new RuntimeException("El tipo de contenido no puede ser distinto de videos, clips, peliculas");
		}else {
			this.contenido = contenido;
		}
	}
	@Override
	public String toString() {
		return "Productora [contenido=" + contenido + "]";
	}
	
	
}
