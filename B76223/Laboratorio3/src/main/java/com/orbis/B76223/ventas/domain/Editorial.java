package com.orbis.B76223.ventas.domain;

import java.util.List;

public class Editorial {

	private int idEditorial; 
	private String nombre; 
	private String direccion;
	private String telefono; 
	private int numeroRegistro;
	private List<Libro> libros;
	
	
	
	public Editorial() {
	}
	public Editorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
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
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public int getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	
	
	
}
