package com.videcartago.renting.domain;

import com.videcartago.renting.inter.FabricaAbstracta;

public class Productora {
	
	private static Productora instancia;
	
	//Para evitar instancia mediante operador "new"
	private Productora() {
		
	}
	
	//Para obtener la instancia unicamente por este metodo
		//Notese la palabra reservada "static" hace posible el acceso mediante Clase.metodo
		public static Productora getInstancia() {
			if(instancia == null) {
				instancia = new Productora();
			}
			return instancia;
		}
		
	public static FabricaAbstracta obtenerFabrica(String tipocontenido) {
	  if(tipocontenido.equalsIgnoreCase("video")) {
		  
		  return new FabricaVideo();
	  } else if (tipocontenido.equalsIgnoreCase("clip")) {
		  
			return new FabricaClip();
			
		} else if (tipocontenido.equalsIgnoreCase("pelicula")) {
			return new FabricaPelicula();
		}
		return null;
	}
}
