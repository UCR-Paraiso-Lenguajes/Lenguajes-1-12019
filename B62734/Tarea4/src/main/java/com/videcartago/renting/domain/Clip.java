package com.videcartago.renting.domain;

public class Clip extends Contenido  {
	private String titulo;

	public Clip(String duracion, String descripcion,String titulo) {
		super(duracion, descripcion);
		this.titulo=titulo;
	}



}
