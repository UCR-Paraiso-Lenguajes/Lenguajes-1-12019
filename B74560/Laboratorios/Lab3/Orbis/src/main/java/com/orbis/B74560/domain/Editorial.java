package com.orbis.B74560.domain;

public class Editorial {

	private int id_editorial;
	private String nombre;
	private String direccion;
	private String telefono;

	public Editorial(int id_editorial, String nombre, String direccion, String telefono) {

		if (id_editorial <= 0)
			throw new RuntimeException("El id están vacio");
		if (nombre.trim().equals("") || direccion.trim().equals("") || telefono.trim().equals(""))
			throw new RuntimeException("Los datos están vacíos");

		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;

	}

	public Editorial() {
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		if (id_editorial <= 0)
			throw new RuntimeException("El id está vacio");
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre.trim().equals(""))
			throw new RuntimeException("Los datos del nombre están vacíos");
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion.trim().equals(""))
			throw new RuntimeException("Los datos de la dirección están vacíos");
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (direccion.trim().equals(""))
			throw new RuntimeException("Los datos del telefono están vacíos");
		this.telefono = telefono;
	}

}
