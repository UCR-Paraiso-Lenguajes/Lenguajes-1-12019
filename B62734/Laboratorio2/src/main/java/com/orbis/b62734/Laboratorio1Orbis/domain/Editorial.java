package com.orbis.b62734.Laboratorio1Orbis.domain;

import java.util.LinkedList;

public class Editorial {
	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private LinkedList<Libro> libros;
	

	public Editorial() {
		super();
		libros=new LinkedList<Libro>();

	}
	public Editorial(int idEditorial, String nombre, String direccion, String telefono) {
		super();
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		libros=new LinkedList<Libro>();
	}
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
	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", libros=" + libros + "]";
	}
	
	
	
	
}
