package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public abstract class CategoriaPeliculaFactory {

	public abstract CategoriaPeliculaProducto categoriaPeliculaProducto(Pelicula pelicula);

}
