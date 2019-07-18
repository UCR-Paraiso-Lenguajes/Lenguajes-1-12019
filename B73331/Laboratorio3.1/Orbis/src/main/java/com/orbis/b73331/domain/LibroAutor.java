package com.orbis.b73331.domain;

import java.util.List;

public class LibroAutor {
	private int id_libro;
	private List<Integer>autores;
	public LibroAutor(int id_libro, List<Integer> autores) {
		if(autores==null) throw new OrbisExcepcion("La lista de autores esta nula");
		if(id_libro == 0) throw new OrbisExcepcion("El id_libro viene vacio");
		this.id_libro = id_libro;
		this.autores = autores;
	}
	public LibroAutor() {
	}
	public int getId_libro() {
		if(id_libro == 0) throw new OrbisExcepcion("El id_libro viene vacio");
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		if(id_libro == 0) throw new OrbisExcepcion("El id_libro viene vacio");
		this.id_libro = id_libro;
	}
	public List<Integer> getAutores() {
		if(autores==null) throw new OrbisExcepcion("La lista de autores esta nula");
		return autores;
	}
	public void setAutores(List<Integer> autores) {
		if(autores==null) throw new OrbisExcepcion("La lista de autores esta nula");
		this.autores = autores;
	}
	
	
}
