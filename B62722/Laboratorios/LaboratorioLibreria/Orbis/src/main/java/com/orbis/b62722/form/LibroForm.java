package com.orbis.b62722.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

import com.orbis.b62722.domain.Autor;
import com.orbis.b62722.domain.Editorial;

public class LibroForm {

	@NotNull
	@Min(2)
	private String titulo;
	@NotNull
	@Past
	private int ano;
	@NotNull
	@Autowired
	private Editorial editorial;
	@NotNull
	private int isbn;
	@Autowired
	@NotNull
	private LinkedList<Autor> autores;

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

	public LinkedList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(LinkedList<Autor> autores) {
		this.autores = autores;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
