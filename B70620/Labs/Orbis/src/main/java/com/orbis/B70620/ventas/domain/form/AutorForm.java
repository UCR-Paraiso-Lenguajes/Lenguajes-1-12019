package com.orbis.B70620.ventas.domain.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orbis.B70620.ventas.domain.Autor;

public class AutorForm {
	private int id;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String apellidos;

	public AutorForm() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setAutorForm(Autor autor) {
		this.id = autor.getId();
		this.apellidos = autor.getApellidos();
		this.nombre = autor.getNombre();
	}
	
	
}
