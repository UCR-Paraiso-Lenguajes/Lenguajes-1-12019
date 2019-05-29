package com.ucr.ac.cr.Examen1.domain;


public enum  Area {

	//Variables Constantes
		Estrategia("Estrategia"), 
		Analisis("Analisis"), 
		Etica("Etica"),
		Habilidades("Habilidades");
	
	private final String nombreArea;

	private Area(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	
}
