package com.orbis.b54524.dominio;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que simula una editotrial, se validan los datos del constructor sean validos
 * @author Equipo
 *
 */
public class Editorial {
	
	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Libro> libros;
	
	/**
	 * Para crear una nueva editorial
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @throws Exception
	 */
	public Editorial(String nombre, String direccion, String telefono) throws Exception {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
	}

	/**
	 * Para guardar datos de la base de datos
	 * @param idEditorial
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @throws Exception
	 */
	public Editorial(int idEditorial, String nombre, String direccion, String telefono) throws Exception {
		setIdEditorial(idEditorial);
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
	}
	
	public Editorial(int idEditorial) throws Exception {
		setIdEditorial(idEditorial);
		
	}

	
	public Editorial() {
		// TODO Auto-generated constructor stub
		libros = new ArrayList<>();
	}

	public int getIdEditorial() {
		int result = idEditorial;
		return result;
	}

	public void setIdEditorial(int idEditorial) throws Exception {
		if(idEditorial > 0) {
			this.idEditorial = idEditorial;
		}else {
			throw new Exception("El id de la editorial debe ser valido");
		}
	}

	public String getNombre() {
		String result = nombre;
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre != null && !nombre.trim().equals("")) {
			this.nombre = nombre;
		}else {
			throw new Exception("El nombre de la editorial debe ser valido");
		}
	}

	public String getDireccion() {
		String result = direccion;
		return result;
	}

	public void setDireccion(String direccion) throws Exception {
		if(direccion != null && !direccion.trim().equals("")) {
			this.direccion = direccion;
		}else {
			throw new Exception("La direccion de la editorial debe ser valido");
		}
	}

	public String getTelefono() {
		String result = telefono;
		return result;
	}

	public void setTelefono(String telefono) throws Exception {
		if(telefono != null && !telefono.trim().equals("")) {
			this.telefono = telefono;
		}else {
			throw new Exception("El telefono de la editorial debe ser valido");
		}
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
}
