package com.orbis.b62722.domain;

public class Editorial {

	private int id_editorial;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Editorial() {
	}

	public int getId_editorial() {
		if(id_editorial <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
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
