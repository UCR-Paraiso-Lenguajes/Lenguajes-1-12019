package com.orbis.b62722.domain;

public class Autor {

	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	
	public Autor() {

	}

	public int getId_autor() {
		return id_autor;
	}


	public void setId_autor(int id_autor) {
		if(id_autor <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		this.id_autor = id_autor;
	}


	public String getNombre_autor() {
		return nombre_autor;
	}


	public void setNombre_autor(String nombre_autor) {
		if(nombre_autor == null || nombre_autor.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre_autor = nombre_autor;
	}


	public String getApellidos_autor() {
		return apellidos_autor;
	}


	public void setApellidos_autor(String apellidos_autor) {
		if(apellidos_autor == null || apellidos_autor.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		this.apellidos_autor = apellidos_autor;
	}
	
	
	
	
	
}
