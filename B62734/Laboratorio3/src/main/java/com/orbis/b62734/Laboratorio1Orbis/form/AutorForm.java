package com.orbis.b62734.Laboratorio1Orbis.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
	private int idAutor;
	@NotNull
	@Size(max=50)
	private String nombreAutor;
	@NotNull
	@Size( max=50)
	private String apellidosAutor;
	
	
	public AutorForm(int idAutor, @NotNull @Size(max = 50) String nombreAutor,
			@NotNull @Size(max = 50) String apellidosAutor) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidosAutor() {
		return apellidosAutor;
	}
	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}
	
	
}
