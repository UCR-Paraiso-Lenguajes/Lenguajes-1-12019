package cr.ac.ucr.ie.lenguajes.domain;

import java.util.ArrayList;



public class Libro {
	private int idLibro;
	private String titulo;
	private int ano;
	private float precio;
	private Editorial editorial;
	private ArrayList<Autor> autores;
	
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libro(int idLibro, String titulo, int ano, float precio, Editorial editorial, ArrayList<Autor> autores) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.editorial = editorial;
		this.autores = autores;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	
}
