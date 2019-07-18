package com.examen.b24075.domain;

import java.util.ArrayList;

public class Curso {
	
	private String nombre;
	private String sigla;
	private int creditos;
	private ArrayList<Curso> requisitos;
	private Plan plan;
	
	
	
	public Curso() {
		this.nombre = "";
		this.sigla = "";
		this.creditos = 0;
		this.requisitos =  new ArrayList<Curso>();
		this.plan = new Plan();
	}
	
	
	public Curso(String nombre, String sigla, int creditos, ArrayList<Curso> requisitos, Plan plan) {
		if(nombre.equals("")  || sigla.equals("")) throw new RuntimeException("Se encuentran datos vacíos");
		if(creditos==0 ) throw new RuntimeException("debe agregar creditos");
		//if(revisarCurso(nombre, sigla, requisitos)) throw new RuntimeException("No puede poner el curso como requisito de si mismo");
		if(plan==null) throw new RuntimeException("plan vacio");
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
		this.requisitos = requisitos;
		this.plan = plan;
	}
	
	//NO DEBE PERMITIR LA CREACIÓN DE UN CURSO Y ÉL MISMO COMO REQUISITO.
	public boolean revisarCurso(String nombre, String sigla, ArrayList<Curso>requisitos ) {
		Curso cursoActual= new Curso();
		for(int indice = 0;indice<requisitos.size();indice++)
		{
			cursoActual= requisitos.get(indice);
		    if(cursoActual.getNombre().equals(nombre)||
		    		cursoActual.getSigla().equals(sigla)) return false;	
		    	
		}
		
		return true;
		
		
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public ArrayList<Curso> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(ArrayList<Curso> requisitos) {
		this.requisitos = requisitos;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	

}
