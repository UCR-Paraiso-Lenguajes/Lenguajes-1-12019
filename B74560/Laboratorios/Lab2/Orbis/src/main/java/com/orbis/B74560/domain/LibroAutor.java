package com.orbis.B74560.domain;

import java.util.List;

import com.orbis.B74560.exception.ExceptionsOrbis;

public class LibroAutor {
	
	private int id_libro;
	private List<Integer>autores;
	
	public LibroAutor(int id_libro, List<Integer> autores) {
		
		if (id_libro<=0) 
			throw new ExceptionsOrbis("El id libro está imcompleto");
		
		if(autores==null) 
			throw new ExceptionsOrbis("La lista de autores esta vacía");
		
		this.id_libro = id_libro;
		this.autores = autores;
	}
	
	public LibroAutor() {
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public List<Integer> getAutores() {
		if(autores==null) 
			throw new ExceptionsOrbis("La lista de autores esta vacía");
		return autores;
	}
	public void setAutores(List<Integer> autores) {
		if(autores==null) 
			throw new ExceptionsOrbis("La lista de autores esta vacía");
		this.autores = autores;
	}
	
}
