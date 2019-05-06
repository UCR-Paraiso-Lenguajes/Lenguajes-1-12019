package com.orbis.b66851.ventas.domain;

public class Editorial {
	
	private int id_editorial;
	private String nombre;
	private String direccion;
	private String telefono;
	
	
	
	public Editorial() {
		
	}

	public Editorial(int id_editorial, String nombre, String direccion, String telefono) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public int getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
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
