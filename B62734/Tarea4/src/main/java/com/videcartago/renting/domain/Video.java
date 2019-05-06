package com.videcartago.renting.domain;

public class Video extends Contenido{
	private String titulo;

	public Video(String duracion, String descripcion,String titulo) {
		super(duracion, descripcion);
		this.titulo=titulo;
	}


}
