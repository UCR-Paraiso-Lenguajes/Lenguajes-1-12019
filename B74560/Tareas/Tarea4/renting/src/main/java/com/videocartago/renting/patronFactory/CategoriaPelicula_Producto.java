package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public abstract class CategoriaPelicula_Producto {

	public abstract void setCategoriaEdad();

	public abstract String getCategoriaEdad();

	// Traer los datos de Pelicula
	public abstract Pelicula getPelicula();

	public abstract void setPelicula(Pelicula pelicula);

}
