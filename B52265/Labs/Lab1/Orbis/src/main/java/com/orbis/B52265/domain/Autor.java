package com.orbis.B52265.domain;

import java.util.ArrayList;

public class Autor {
	private int idAutor;
	private String nombreAutor;
	private String apellidosAutor;
	private ArrayList<Libro> libros;

	public Autor(int idAutor, String nombreAutor, String apellidosAutor, ArrayList<Libro> libros) {
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
		this.libros = libros;
	}

	public Autor() {
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

	public String getApellidosAutor() {
		return apellidosAutor;
	}

	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}

	public boolean existeAutor() {
		return false;
	}

	public boolean validaCampoIsEmpty() {
		return false;
	}

	public boolean validaCampoAlfabetico() {
		return false;
	}

	public boolean validaCaracteres() {
		return false;
	}

	public boolean validaSize() {
		return false;
	}

	public boolean validaCampoNumerico() {
		return false;
	}
}
