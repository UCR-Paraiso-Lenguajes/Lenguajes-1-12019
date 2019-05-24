package com.orbis.b62734.Laboratorio1Orbis.form;

import java.util.LinkedList;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b62734.Laboratorio1Orbis.domain.*;

public class LibroForm {
	private int codLibro;
	@NotNull
	@Size(min=2, max=50)
	private String titulo;
	@NotNull
	@Min(2)
	private short ano;
	private float precio;
	@Autowired
	private LinkedList<Autor> autores;
	@Autowired
	private Editorial editorial;
	
	public int getCodLibro() {
		return codLibro;
	}
	public void setCodLibro(int codLibro) {
		this.codLibro = codLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public short getAno() {
		return ano;
	}
	public void setAno(short ano) {
		this.ano = ano;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
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
	
}
