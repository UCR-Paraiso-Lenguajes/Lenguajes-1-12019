package com.orbis.B54187.ventas.domain;

public class Editorial {
	
	private int id_editorial;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Editorial() {
		
	}
	
	public int getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(int id_autor) {
		this.id_editorial = id_autor;
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

}
