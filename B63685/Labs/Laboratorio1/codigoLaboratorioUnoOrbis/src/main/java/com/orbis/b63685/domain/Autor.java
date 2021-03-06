package com.orbis.b63685.domain;

import java.util.ArrayList;

public class Autor {
	
	private ArrayList<Libro> libros;
	private int idAutor;
	private String nombreAutor;
	private String apellidoAutor;
	
	
	
	public Autor(ArrayList<Libro> libros, int idAutor, String nombreAutor, String apellidoAutor) {
		super();
		this.libros = libros;
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		
		
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidoAutor() {
		return apellidoAutor;
	}
	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}
	
	
	

}
