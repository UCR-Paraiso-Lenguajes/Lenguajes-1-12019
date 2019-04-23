package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public class CategoriaMayorDoce extends CategoriaPeliculaProducto {

	public CategoriaMayorDoce(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getCategoriaTipo() {
		return this.categoriaTipo;
	}

	public void setCategoriaTipo() {
		this.categoriaTipo = CategoriaPeliculas.MayorDeDoce.getNombreCategoria();
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
