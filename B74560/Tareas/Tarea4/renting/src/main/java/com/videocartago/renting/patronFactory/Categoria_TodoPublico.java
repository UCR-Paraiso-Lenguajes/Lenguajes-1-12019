package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public class Categoria_TodoPublico extends CategoriaPelicula_Producto {

	private Pelicula pelicula;
	private String categoriaTipo;

	public Categoria_TodoPublico(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getCategoriaEdad() {
		return this.categoriaTipo;
	}

	public void setCategoriaEdad() {
		this.categoriaTipo = "TP";
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
