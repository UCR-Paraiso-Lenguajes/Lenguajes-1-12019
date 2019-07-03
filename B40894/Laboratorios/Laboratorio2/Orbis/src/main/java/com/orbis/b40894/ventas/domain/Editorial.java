package com.orbis.b40894.ventas.domain;

import java.util.List;

public class Editorial {

	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private List<Libro> librosPorEditoral;

	public Editorial() {

	}

	public Editorial(int idEditorial, String nombre, String direccion, String telefono, List<Libro> libro) {
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.librosPorEditoral = libro;
	}
	
	public Editorial(int idEditorial, String nombre, String direccion, String telefono) {
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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

	public List<Libro> getLibro() {
		return librosPorEditoral;
	}

	public void setLibro(List<Libro> libro) {
		this.librosPorEditoral = libro;
	}

	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

}