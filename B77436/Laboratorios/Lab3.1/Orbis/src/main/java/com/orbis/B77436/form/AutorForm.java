package com.orbis.B77436.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
	@NotNull
	private int id_autor;
	@NotNull
	@Size (min=2, max=50)
	private String nombre_autor;
	@NotNull
	@Size (min=2, max=50)
	private String apellidos_autor;
	
	public AutorForm() {
		
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}
	
	
	
}
