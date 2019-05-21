package com.orbis.B70620.ventas.domain;

import java.util.ArrayList;

public class Autor {

	private int id;
	private String nombre;
	private String apellidos;
	private ArrayList<Libro> libros;
	
	
	public Autor(int id, String nombre, String apellidos, ArrayList<Libro> libros) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setLibros(libros);
	}
	public Autor(int id, String nombre, String apellidos) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
	}
	public Autor() {
		id = 0;
		nombre = "";
		apellidos = "";
		libros = new ArrayList<>();
	}
	
	public boolean idEsValido(int id) {
		return id < 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(idEsValido(id))
			throw new RuntimeException("El id no puede ser negativo!");
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals(""))
			throw new RuntimeException("El nombre no es valido!");
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		if(apellidos == null || apellidos.trim().equals(""))
			throw new RuntimeException("Los apellidos no son validos!");
		this.apellidos = apellidos;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		if(libros == null)
			throw new NullPointerException("La lista libros no puede ser nula!");
		this.libros = libros;
	}
	
	
}
