package com.ucr.ac.cr.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class Curso {

	private int idArea;//se refiere a 1 si es estrategia e innovacion, 2 analisis e investigacion.
	private String nombreCurso;
	private String siglasCurso;
	private int creditosCurso;
	private ArrayList<String> requisitosCurso;//contiene las siglas de los cursos que son requisito 
	private int numCiclo;

	public Curso(int idArea, String nombreCurso, String siglasCurso, int creditosCurso,
			ArrayList<String> requisitosCurso, int idCiclo) {
		
		
		if(nombreCurso == null || nombreCurso.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
		if(siglasCurso == null || siglasCurso.trim().toLowerCase().equals("")) throw new RuntimeException("La sigla del curso es requerido.");
		//if(creditosCurso > 0 ) throw new RuntimeException("los creditos tienen que ser mayor a cero");
		if(numCiclo > 0 ) throw new RuntimeException("los numero del ciclo tienen que ser mayor a cero");
		
		this.idArea = idArea;
		this.nombreCurso = nombreCurso;
		this.siglasCurso = siglasCurso;
		this.creditosCurso = creditosCurso;
		this.requisitosCurso = requisitosCurso;
		this.numCiclo = idCiclo;
	}
	
	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public Curso(int idCurso, String nombreCurso, String siglasCurso, int creditosCurso,
			 int idCiclo) {
		
		this.idArea = idCurso;
		this.nombreCurso = nombreCurso;
		this.siglasCurso = siglasCurso;
		this.creditosCurso = creditosCurso;
		this.numCiclo = idCiclo;
	}

	public int getNumCiclo() {
		return numCiclo;
	}

	public void setNumCiclo(int idCiclo) {
		this.numCiclo = idCiclo;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getSiglasCurso() {
		return siglasCurso;
	}

	public void setSiglasCurso(String siglasCurso) {
		this.siglasCurso = siglasCurso;
	}

	public int getCreditosCurso() {
		return creditosCurso;
	}

	public void setCreditosCurso(int creditosCurso) {
		this.creditosCurso = creditosCurso;
	}

	public ArrayList<String> getRequisitosCurso() {
		return requisitosCurso;
	}

	public void setRequisitosCurso(ArrayList<String> requisitosCurso) {
		this.requisitosCurso = requisitosCurso;
	}


}
