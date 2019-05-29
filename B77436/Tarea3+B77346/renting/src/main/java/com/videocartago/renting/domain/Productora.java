package com.videocartago.renting.domain;

public class Productora {
	
	private static Productora instance = new Productora(); 
	
	private String contenidoProductora;
	
	private Productora() {
		
	}
	
	public static Productora getInstance() {
		return instance;
	}

	public String getContenidoProductora() {
		return contenidoProductora;
	}

	public void setContenidoProductora(String contenidoProductora) {
		this.contenidoProductora = contenidoProductora;
	}

	
	

}
