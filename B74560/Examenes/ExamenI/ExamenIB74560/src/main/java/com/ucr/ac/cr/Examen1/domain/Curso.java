package com.ucr.ac.cr.Examen1.domain;

import  com.ucr.ac.cr.Examen1.exception.ExamenException;

public class Curso {

	private String nombreCurso;
	private String area;
	private String siglaCurso;
	private int credictos;
	private int ciclo;

	public Curso(String nombreCurso, String area, String siglaCurso, int credictos, int ciclo) {
		
		//validacion curso
		if (nombreCurso.trim().isEmpty() || area.trim().isEmpty() || siglaCurso.trim().isEmpty()) 
			throw new ExamenException("Los campos son requeridos.");
		
		//validacion area
		/*if ( Area.Analisis.getNombreArea().contentEquals(area) || Area.Estrategia.getNombreArea().contentEquals(area) 
				|| Area.Etica.getNombreArea().contentEquals(area) || Area.Habilidades.getNombreArea().contentEquals(area)) 
			throw new ExamenException("Nombre no coincide con ninguna Area registrada.");*/
		
		//validacion credictos, ciclo
		if (credictos<0 || ciclo<0) 
			throw new ExamenException("Los campos son requeridos, numeros enteros positivos.");
		
		this.nombreCurso = nombreCurso;
		this.area = area;
		this.siglaCurso = siglaCurso;
		this.credictos = credictos;
		this.ciclo = ciclo;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		if (nombreCurso.trim().isEmpty()) 
			throw new ExamenException("Los campos son requeridos.");
		this.nombreCurso = nombreCurso;
	}

	public String getSiglaCurso() {
		return siglaCurso;
	}

	public void setSiglaCurso(String siglaCurso) {
		if (siglaCurso.trim().isEmpty()) 
			throw new ExamenException("Los campos son requeridos.");
		this.siglaCurso = siglaCurso;
	}

	public int getCredictos() {
		return credictos;
	}

	public void setCredictos(int credictos) {
		if (credictos<0) 
			throw new ExamenException("Los campos son requeridos, numeros enteros positivos.");
		this.credictos = credictos;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		if (ciclo<0) 
			throw new ExamenException("Los campos son requeridos, numeros enteros positivos.");
		this.ciclo = ciclo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		if (Area.Analisis.getNombreArea().equals(area) || Area.Estrategia.getNombreArea().equals(area)
				|| Area.Etica.getNombreArea().equals(area) || Area.Habilidades.getNombreArea().equals(area)) {
			throw new ExamenException("Nombre no coincide con ninguna Area registrada");
		}
		this.area = area;
	}

}
