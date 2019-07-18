package cr.ac.ucr.ie.lenguajes.domain;

import java.util.ArrayList;

public class Libro {
	private int id_libro;
	private String nombre_libro;
	private short ano;
	private float precio;
	private Editorial editorial;
	private ArrayList<Autor> autores = new ArrayList<>() ;
	
	public Libro() {
		editorial = new Editorial();
	}
	

	public Libro(int id_libro, String nombre_libro, short ano, float precio,Editorial editorial) {
		setId_libro(id_libro);
		setNombre_libro(nombre_libro);
		setAno(ano);
		setPrecio(precio);
		setEditorial(editorial);
	}

	private boolean validacionesString() {
		//TODO
		return true;
	}
	
	private boolean validacionesId() {
		//TODO
		return true;
	}
	
	private boolean validacionesFecha() {
		//TODO
		return true;
	}
	
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		if(validacionesId()) this.id_libro = id_libro;
		else throw new RuntimeException("Debe ingresar un ID válido");
	}
	public String getNombre_libro() {
		return nombre_libro;
	}
	public void setNombre_libro(String nombre_libro) {
		if(validacionesString()) this.nombre_libro = nombre_libro;
		else throw new RuntimeException("El nombre no puede estar vacío");
	}
	public short getAno() {
		return ano;
		
	}
	public void setAno(short ano) {
		if(validacionesFecha())	this.ano = ano;
		else throw new RuntimeException("Debe ingresar un año válido");
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		if(precio >= 0)	this.precio = precio;
		else throw new RuntimeException("Debe ingresar un precio positivo ó 0");
	}



	public ArrayList<Autor> getAutores() {
		return autores;
	}



	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	
	
}
