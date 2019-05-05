package com.videocartago.renting.Factory;

import com.videocartago.renting.domain.PeliculaMayoresDe12;
import com.videocartago.renting.domain.PeliculaMayoresDe18;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.PeliculaTodoPublico;

public class FabricaPeliculasCategoria extends PeliculaAbstract{
	
	@Override
	public PeliculaAbtractTipo categoriaEdad(Pelicula pelicula) {
		if(pelicula==null) {
			throw new RuntimeException("La pelicula esta vacia");
		}else if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Terror")) {
			PeliculaMayoresDe18 pelicula18 = new PeliculaMayoresDe18(pelicula);
			pelicula18.setCategoriaEdad();
			return pelicula18;
		}else if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Suspenso")) {
			PeliculaMayoresDe12 peliculas12 = new PeliculaMayoresDe12(pelicula);
			peliculas12.setCategoriaEdad();
			return peliculas12;
		}else {
			PeliculaTodoPublico peliculasTP = new PeliculaTodoPublico(pelicula);
			peliculasTP.setCategoriaEdad();
			return peliculasTP;
		}

	}

}
