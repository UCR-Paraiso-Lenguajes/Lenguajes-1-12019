package com.orbis.b63685.domain;

import java.util.ArrayList;

public class Editorial {

	private int idEditorial;
	private String direccion;
	private String nombre;
	private String telefono;
	private ArrayList<Libro> libros;
	
	

	public Editorial(int idEditorial, String direccion, String nombre, String telefono, ArrayList<Libro> libros) {
		super();
		this.idEditorial = idEditorial;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.libros = libros;
	}


	public Editorial() {
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Libro> getLibros() {
		return libros;
	}


	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}


	public int getIdEditorial() {
		return idEditorial;
	}


	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
