package com.videocartago.renting.patronFactory;

import com.videocartago.renting.domain.Pelicula;

public class CategoriaPelicula_Factoria extends CategoriaPelicula_Factory {

	@Override
	public CategoriaPelicula_Producto categoriaPelicula_Producto(Pelicula pelicula) {

		if (pelicula == null) {
			throw new RuntimeException("Error en los datos de pelicula ");
		} else if (pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Terror")) {
			Categoria_MayorDieciocho categoria_Mayor12 = new Categoria_MayorDieciocho(pelicula);
			categoria_Mayor12.setCategoriaEdad();
			return categoria_Mayor12;
		} else if (pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Suspenso")) {
			Categoria_MayorDoce categoria_MayorDoce = new Categoria_MayorDoce(pelicula);
			categoria_MayorDoce.setCategoriaEdad();
			return categoria_MayorDoce;
		} else {
			Categoria_TodoPublico Categoria_TP = new Categoria_TodoPublico(pelicula);
			Categoria_TP.setCategoriaEdad();
			return Categoria_TP;
		}

	}

}
