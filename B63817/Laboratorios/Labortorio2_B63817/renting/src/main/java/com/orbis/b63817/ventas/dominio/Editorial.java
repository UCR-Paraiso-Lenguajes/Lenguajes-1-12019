package com.orbis.b63817.ventas.dominio;

import java.util.ArrayList;

public class Editorial {
	
	private int id_Editorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Libro> listaLibros;
	
	
	
	
	public Editorial(int id_Editorial, String nombre, String direccion, String telefono) {
		super();
		if(id_Editorial <0) throw new RuntimeException("El id de Editorial debe ser mayor  0.");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(direccion == null || direccion.trim().equals("")) throw new RuntimeException("La direcciòn es requerido");
		if(telefono == null || telefono.trim().equals("")) throw new RuntimeException("El telefono es requerido");
		listaLibros= new ArrayList<Libro>();
		this.id_Editorial = id_Editorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Editorial() {
		
	}

	public int getId_Editorial() {
		return id_Editorial;
	}
	public void setId_Editorial(int id_Editorial) {
		this.id_Editorial = id_Editorial;
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

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	@Override
	public String toString() {
		return "Editorial [id_Editorial=" + id_Editorial + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	

}
