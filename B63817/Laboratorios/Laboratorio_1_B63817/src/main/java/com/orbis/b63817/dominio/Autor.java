package com.orbis.b63817.dominio;

import java.util.ArrayList;

public class Autor {
	
	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	private ArrayList<Libro> listaLibros;
	
	public Autor() {
		
	}

	public Autor(int id_autor, String nombre_autor, String apellidos_autor, ArrayList<Libro> listaLibros) {
		super();
		if(id_autor <0) throw new RuntimeException("El id de Autor debe ser mayor  0.");
		if(nombre_autor == null || nombre_autor.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidos_autor == null || apellidos_autor.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		this.listaLibros = listaLibros;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	

}
