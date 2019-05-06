package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public abstract class CategoriaPeliculaProducto {

	// Variables
	protected String categoriaTipo;

	protected Pelicula pelicula;

	// Traer los datos de Categoria de Pelicula
	public abstract void setCategoriaTipo();

	public abstract String getCategoriaTipo();

	// Traer los datos de Pelicula
	public abstract Pelicula getPelicula();

	public abstract void setPelicula(Pelicula pelicula);

}
