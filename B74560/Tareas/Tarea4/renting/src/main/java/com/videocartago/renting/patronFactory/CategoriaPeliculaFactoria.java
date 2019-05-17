package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public class CategoriaPeliculaFactoria extends CategoriaPeliculaFactory {

	@Override
	public CategoriaPeliculaProducto categoriaPeliculaProducto(Pelicula pelicula) {

		if (pelicula == null) {
			throw new RuntimeException("Error en los datos de pelicula ");
		} else if (pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Terror")) {
			CategoriaMayorDieciocho categoriaMayorDieciocho = new CategoriaMayorDieciocho(pelicula);
			categoriaMayorDieciocho.setCategoriaTipo();
			return categoriaMayorDieciocho;
		} else if (pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Suspenso")) {
			CategoriaMayorDoce categoriaMayorDoce = new CategoriaMayorDoce(pelicula);
			categoriaMayorDoce.setCategoriaTipo();
			return categoriaMayorDoce;
		} else {
			CategoriaTodoPublico CategoriaTP = new CategoriaTodoPublico(pelicula);
			CategoriaTP.setCategoriaTipo();
			return CategoriaTP;
		}

	}

}
