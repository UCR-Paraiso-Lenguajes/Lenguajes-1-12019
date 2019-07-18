package com.videocartago.renting.singleton;

import com.videcartago.renting.domain.Pelicula;

/*
 1. Patrones de creación
 
 Para singleton: 
 
 1-El constructor debe ser privado
 
 2-En segundo lugar necesitaremos disponer de una variable estatica privada que almacene una referencia al objeto que vamos a crear a traves del constructor .
 
 3. Por ultimo un método estático publico que se encarga de instanciar el objeto la primera vez y almacenarlo en la variable estática.
 */

public class Productora {

	private String video;
	private String clip;
	private Pelicula pelicula;

	private static Productora productora;

	private Productora(String video, String clip, Pelicula pelicula) {

		this.video = video;// recordar hacer validaciones de null
		this.clip = clip;
		this.pelicula = pelicula;

	}

	public static Productora getInstanceProductora(String video, String clip, Pelicula pelicula) {

		if (productora == null) {

			productora = new Productora(video, clip, pelicula);
		}

		return productora;
	}

	

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getClip() {
		return clip;
	}

	public void setClip(String clip) {
		this.clip = clip;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
