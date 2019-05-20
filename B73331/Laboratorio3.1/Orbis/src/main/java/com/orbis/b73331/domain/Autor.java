package com.orbis.b73331.domain;

public class Autor {
	
	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	public Autor(int id_autor, String nombre_autor, String apellidos_autor) {
		if(id_autor==0) throw new OrbisExcepcion("El id viene vació");
		if(nombre_autor.equals("") || apellidos_autor.equals("")) throw new OrbisExcepcion("Los datos viene incompletos");
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
	}
	
	public Autor() {
	}

	public int getId_autor() {
		if(id_autor==0) throw new OrbisExcepcion("El id viene vacio");
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		if(id_autor==0) throw new OrbisExcepcion("El id viene vacio");
		this.id_autor = id_autor;
	}
	public String getNombre_autor() {
		if(nombre_autor.equals("") || nombre_autor == null) throw new OrbisExcepcion("nombre_autor viene vacio");
		return nombre_autor;
	}
	public void setNombre_autor(String nombre_autor) {
		if(nombre_autor.equals("") || nombre_autor == null) throw new OrbisExcepcion("nombre_autor viene vacio");
		this.nombre_autor = nombre_autor;
	}
	public String getApellidos_autor() {
		if(apellidos_autor.equals("") || apellidos_autor == null) throw new OrbisExcepcion("apellidos_autor viene vacio");
		return apellidos_autor;
	}
	public void setApellidos_autor(String apellidos_autor) {
		if(apellidos_autor.equals("") || apellidos_autor == null) throw new OrbisExcepcion("apellidos_autor viene vacio");
		this.apellidos_autor = apellidos_autor;
	}
	
	

}
