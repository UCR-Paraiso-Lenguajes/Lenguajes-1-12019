package com.videocartago.renting.domain;

public class Productora {
	
	private static Productora instance = new Productora();
	private String tipoContenido;
	
	private Productora() {
		
	}
	
	public static Productora getInstance() {
		return instance;
	}

	public String getTipoContenido() {
		return tipoContenido;
	}

	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}

	@Override
	public String toString() {
		return "Productora [tipoContenido=" + tipoContenido + "]";
	}
	
	
	

}
