package cr.ac.ucr.ie.domain;

import java.util.LinkedList;

public class Biblioteca {
	
	/*
	 * Tip 2
	 * Nombres significativos para variables
	 *En este caso se utilizan nombres para una lista por tanto se usa un plural, relacionadas al objeto
	 *no se utilizan prefijos puesto no cambiaria su significado
	 *Nombres cortos 
	 *ver Pag de 45 a 50*/
	public LinkedList<Libro> libros = new LinkedList<>();
	public LinkedList<Audivisuales> audivisuales = new LinkedList<>();
	
	public Biblioteca() {
		
	}

	/*Tip 3
	 * El siguiente bloque de métodos, su función es modificación y acceso, por tanto se utilizan los
	 * prefijos correspondientes: get para acceso, set para modificación
	 * ver Pag 53*/
	public LinkedList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(LinkedList<Libro> libros) {
		this.libros = libros;
	}

	public LinkedList<Audivisuales> getAudivisuales() {
		return audivisuales;
	}

	public void setAudivisuales(LinkedList<Audivisuales> audivisuales) {
		this.audivisuales = audivisuales;
	}
	
}
