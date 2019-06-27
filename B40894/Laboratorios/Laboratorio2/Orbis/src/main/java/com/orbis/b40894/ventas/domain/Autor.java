package com.orbis.b40894.ventas.domain;

import java.util.List;

public class Autor {

	private int idAutor;
	private String nombreAutor;
	private String apellidosAutor;
	private List<Libro> librosPorAutor;
	public int getIdAutor() {
		return idAutor;
	}
	
	public Autor(int idAutor, String nombreAutor, String apellidosAutor, List<Libro> librosPorAutor) {
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
		this.librosPorAutor = librosPorAutor;
	}



	public Autor() {
		super();
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
	public List<Libro> getLibrosPorAutor() {
		return librosPorAutor;
	}
	public void setLibrosPorAutor(List<Libro> librosPorAutor) {
		this.librosPorAutor = librosPorAutor;
	}
	@Override
	public String toString() {
		return "Autores [idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + ", apellidosAutor=" + apellidosAutor
				+ ", librosPorAutor=" + librosPorAutor + "]";
	}
	
	
	
}
