package com.ucr.ac.cr.planDeEstudios.domain;

import java.util.List;

public class PlanDeEstudios {
	
	
	private String nombre;
	private int cantidadDeCursos;
	private int creditosTotales;
	private List<Curso> cursosInvolucrados;
	private int idPlan;
	
	public PlanDeEstudios(int idPlan,String nombre, int cantidadDeCursos, int creditosTotales, List<Curso> cursosInvolucrados) {
		super();
		this.nombre = nombre;
		this.cantidadDeCursos = cantidadDeCursos;
		this.creditosTotales = creditosTotales;
		this.cursosInvolucrados = cursosInvolucrados;
		this.idPlan = idPlan;
	}


	public PlanDeEstudios() {
		// TODO Auto-generated constructor stub
	}


	public int getIdPlan() {
		return idPlan;
	}


	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidadDeCursos() {
		return cantidadDeCursos;
	}


	public void setCantidadDeCursos(int cantidadDeCursos) {
		this.cantidadDeCursos = cantidadDeCursos;
	}


	public int getCreditosTotales() {
		return creditosTotales;
	}


	public void setCreditosTotales(int creditosTotales) {
		this.creditosTotales = creditosTotales;
	}


	public List<Curso> getCursosInvolucrados() {
		return cursosInvolucrados;
	}


	public void setCursosInvolucrados(List<Curso> cursosInvolucrados) {
		this.cursosInvolucrados = cursosInvolucrados;
	}
	
	
	
	
}