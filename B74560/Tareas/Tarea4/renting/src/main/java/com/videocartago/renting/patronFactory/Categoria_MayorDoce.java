package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public class Categoria_MayorDoce extends CategoriaPelicula_Producto {

	private Pelicula pelicula;
	private String categoriaTipo;

	public Categoria_MayorDoce(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getCategoriaEdad() {
		return this.categoriaTipo;
	}

	public void setCategoriaEdad() {
		this.categoriaTipo = "+12";
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
