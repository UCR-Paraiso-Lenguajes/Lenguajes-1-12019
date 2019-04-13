package com.videocartago.renting.patronSingleton;

public class Productora {

	private static Productora instancia  = null;
	private String tipoContenido = "";
	public Productora() {
		
	}
	public static Productora getInstance(){
		
		if (instancia == null) {
			instancia = new Productora();
		}
        return instancia;
    }
	public String getTipoContenido() {
		return tipoContenido;
	}
	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	
	
}
