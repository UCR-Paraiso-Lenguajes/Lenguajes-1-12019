package com.orbis.B52265.domain;

import java.util.ArrayList;

public class Editorial {
	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Libro> libros;

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


	public boolean existeEditorial() {
		return false;
	}

	public boolean validaCampoIsEmpty() {
		return false;
	}

	public boolean validaCaracteres() {
		return false;
	}

	public boolean validaNumerico() {
		return false;
	}

	public boolean validaSize() {
		return false;
	}
}
