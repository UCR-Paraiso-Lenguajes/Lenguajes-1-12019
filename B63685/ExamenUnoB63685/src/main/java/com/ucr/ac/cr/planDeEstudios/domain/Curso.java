package com.ucr.ac.cr.planDeEstudios.domain;

import java.util.List;

public class Curso {
	
	private int idCurso;
	private String nombre;
	private String siglas;
	private int creditos;
    private Curso requisito;
    private boolean isFinalOrInicial;
    
    //se utiliza cuando el curso tiene requisito
	public Curso(int idCurso, String nombre, String siglas, int creditos, Curso requisito, boolean isFinalOrInicial) {
		super();
		this.nombre = nombre; if(nombre == null || nombre.trim().toLowerCase().equals("")) throw new RuntimeException("El nombre es requerido.");
		this.siglas = siglas;
		this.creditos = creditos;
		this.requisito = requisito;	if(idCurso == requisito.getIdCurso()) throw new RuntimeException("No se permite la creación de un curso y el mismo como requisito.");

		this.isFinalOrInicial = isFinalOrInicial;if(isFinalOrInicial) throw new RuntimeException("El curso final no puede ser requisito de ningún otro curso.");
		this.idCurso = idCurso;
		
		
		


	}
	//se utiliza cuando el curso no tiene requisitos
	public Curso(int idCurso, String nombre, String siglas, int creditos,boolean isFinalOrInicial) {
		super();
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.isFinalOrInicial = isFinalOrInicial;
		this.idCurso = idCurso;

	}
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public boolean isFinalOrInicial() {
		return isFinalOrInicial;
	}
	public void setFinalOrInicial(boolean isFinalOrInicial) {
		this.isFinalOrInicial = isFinalOrInicial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public Curso getRequisito() {
		return requisito;
	}
	public void setRequisito(Curso requisito) {
		this.requisito = requisito;
	}
    
    
    


}