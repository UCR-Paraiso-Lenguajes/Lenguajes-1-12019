package com.orbis.b54524.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase para simular un libro, se valida que los atributos para el constructor sean validos
 * @author Equipo
 *
 */
public class Libro {
	private int idLibro;
	private String titulo;
	private short anio;
	private float precio;
	private ArrayList<Autor> autores;
	private Editorial editorial;
	
	/**
	 * Para generar un nuevo libro con editorial
	 * @param titulo
	 * @param anio
	 * @param precio
	 * @param autores
	 * @param editorial
	 * @throws Exception 
	 */
	public Libro(String titulo, short anio, float precio, ArrayList<Autor> autores, Editorial editorial) throws Exception {
		setTitulo(titulo);
		setAnio(anio);
		setPrecio(precio);
		setAutores(autores);
		setEditorial(editorial);
	}
	
	/**
	 * Para guardar datos de la base de datos
	 * @param idLibro
	 * @param titulo
	 * @param anio
	 * @param precio
	 * @param autores
	 * @param editorial
	 * @throws Exception 
	 */
	public Libro(int idLibro, String titulo, short anio, float precio, ArrayList<Autor> autores, Editorial editorial) throws Exception {
		setIdLibro(idLibro);
		setTitulo(titulo);
		setAnio(anio);
		setPrecio(precio);
		setAutores(autores);
		setEditorial(editorial);
	}
	
	/**
	 * Para crear un nuevo libro sin editorial
	 * @param titulo
	 * @param anio
	 * @param precio
	 * @param autores
	 * @throws Exception 
	 */
	public Libro(String titulo, short anio, float precio, ArrayList<Autor> autores) throws Exception {
		setTitulo(titulo);
		setAnio(anio);
		setPrecio(precio);
		setAutores(autores);
	}
	
	/**
	 * Utilizada para cargar los datos de la base de datos
	 */
	public Libro() {
		// TODO Auto-generated constructor stub
		autores = new ArrayList<>();
	}

	public int getIdLibro() {
		int result = idLibro;
		return result;
	}

	public void setIdLibro(int idLibro) throws Exception {
		//if(idLibro > 0) {
			this.idLibro = idLibro;
		//}else {
		//	throw new Exception("El id del libro es invalido");
		//}
	}

	public String getTitulo() {
		String result = titulo;
		return result;
	}

	public void setTitulo(String titulo) throws Exception {
		if(titulo != null && !titulo.trim().equals("")) {
			this.titulo = titulo;
		}else {
			throw new Exception("El titulo del libro es invalido");
		}
	}

	public short getAnio() {
		short result = anio;
		return result;
	}

	public void setAnio(short anio) throws Exception {
		//if(anio > 0) {
			this.anio = anio;
		//}else {
		//	throw new Exception("El año del libro es invalido");
		//}
	}

	public float getPrecio() {
		float result = precio;
		return result;
	}

	public void setPrecio(float precio) throws Exception {
		//if(precio > 0) {
			this.precio = precio;
		//}else {
		//	throw new Exception("El precio del libro es invalido");
		//}
	}

	public ArrayList<Autor> getAutores() {
		ArrayList<Autor> result = autores;
		return result;
	}
	
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public Editorial getEditorial() {
		Editorial result = editorial;
		return result;
	}

	public void setEditorial(Editorial editorial) throws Exception {
		//if(editorial != null) {
			this.editorial = editorial;
		//}else {
		//	throw new Exception("La editorial debe ser valida");
		//}
	}
}
