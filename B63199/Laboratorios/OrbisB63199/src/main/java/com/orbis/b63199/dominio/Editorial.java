package com.orbis.b63199.dominio;

import java.util.ArrayList;

public class Editorial {
	private int id_editorial;
	private String nombre;
	private String direcion;
	private String telefono;
//	private ArrayList<Libro> libros;
	
	public Editorial(int id_editorial, String nombre, String direcion, String telefono) {
		super();
		if(id_editorial<0) throw new RuntimeException("Id no valida");
		this.id_editorial = id_editorial;
		if(nombre!=null)  throw new RuntimeException("Nombre no valido");
		this.nombre = nombre;
		if(direcion!=null)  throw new RuntimeException("direccion no valido");
		this.direcion = direcion;
		if(telefono!=null)  throw new RuntimeException("Nombre no valido");
		this.telefono = telefono;
		//if(libros!=null)  throw new RuntimeException("Nombre no valido");
	//	this.libros = libros;
	}
	
	
	public Editorial() {
		super();
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}/*
	public ArrayList<Libro> getAutores() {
		return libros;
	}

	public void setAutores(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	

	*/
	
	
	
	
}
