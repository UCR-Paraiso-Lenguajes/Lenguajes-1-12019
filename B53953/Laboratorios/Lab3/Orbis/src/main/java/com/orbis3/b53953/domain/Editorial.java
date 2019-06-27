package com.orbis3.b53953.domain;


import java.util.ArrayList;
import java.util.Iterator;

public class Editorial {

	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Libro> libros;

	public Editorial(int id, String nombre, String direccion, String telefono, ArrayList<Libro> libros) {
		setId(id);
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
		setLibros(libros);
	}

	public Editorial() {
		id = 0;
		nombre = "";
		direccion = "";
		telefono = "";
		libros = new ArrayList<>();
	}

	public boolean idEsValido(int id) {
		return id < 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (idEsValido(id))
			throw new RuntimeException("El id no puede ser negativo!");
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().equals(""))
			throw new RuntimeException("El nombre no es valido!");
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || direccion.trim().equals(""))
			throw new RuntimeException("La direccion no es valido!");
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null || telefono.trim().equals(""))
			throw new RuntimeException("El telefono no es valido!");
		this.telefono = telefono;
	}

	public Iterator<Libro> getLibros() {
		return libros.iterator();
	}

	public void setLibros(ArrayList<Libro> libros) {
		if (libros == null)
			throw new NullPointerException("La lista libros no puede ser nula!");
		this.libros = libros;
	}
}
