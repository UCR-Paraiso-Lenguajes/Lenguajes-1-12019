package com.orbis.b63199.dominio;

import java.util.ArrayList;

public class Autor {

	private int id_autor;
	private String nombre;
	private String apellidos;
	private ArrayList<Libro> librosEscritos;
	public Autor(int id_autor, String nombre, String apellidos, ArrayList<Libro> librosEscritos) {
		if(id_autor<0) throw new RuntimeException("Id no valida");
		this.id_autor = id_autor;
		if(nombre!=null)  throw new RuntimeException("direccion no valido");
		this.nombre = nombre;
		if(apellidos!=null)  throw new RuntimeException("direccion no valido");
		this.apellidos = apellidos;
		if(librosEscritos!=null)  throw new RuntimeException("direccion no valido");
		this.librosEscritos = librosEscritos;
	}
	
	
	
	public Autor() {
		super();
	}



	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public ArrayList<Libro> getLibrosEscritos() {
		return librosEscritos;
	}
	public void setLibrosEscritos(ArrayList<Libro> librosEscritos) {
		this.librosEscritos = librosEscritos;
	}
	
	
	
	
}
