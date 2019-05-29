package com.examen1.plan.estudios.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Curso{
	private String siglas;
	private String nombre;
	private int creditos;
	private ArrayList<String> requisitos;

	public Curso(String siglas, String nombre, int creditos) {
		setSiglas(siglas);
		setNombre(nombre);
		setCreditos(creditos);
		requisitos = new ArrayList<String>();
	}

	protected void agregarCurso(String nuevoRequisito) {
		if (siglas.equals(nuevoRequisito))
			throw new RuntimeException("El curso no puede ser requisito de el mismo");
		requisitos.add(nuevoRequisito);
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		if (siglas == null || siglas.trim().equals(""))
			throw new RuntimeException("Las siglas no son validas!");
		this.siglas = siglas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().equals(""))
			throw new RuntimeException("El nombre no es valido!");
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		if (creditos < 0)
			throw new RuntimeException("Los creditos no pueden ser negativos!");
		this.creditos = creditos;
	}

	public int obtenerCantidadRequisitos() {
		return requisitos.size();
	}
	
	public boolean esRequisito(Curso curso) {
		for (int i = 0; i < requisitos.size(); i++)
			if(requisitos.get(i).equalsIgnoreCase(curso.getSiglas()))
				return true;
		return false;
	}
}
