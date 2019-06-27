package com.orbis.b63685.Laboratorio2Orbis.domain;

import java.util.LinkedList;

public class Editorial {
	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private LinkedList<Libro> libros;

	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int id_editorial) {
		this.idEditorial = id_editorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LinkedList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(LinkedList<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	
}
