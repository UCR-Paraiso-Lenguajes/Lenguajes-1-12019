package com.videocartago.renting.factory;

import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.PeliculaMayores12;
import com.videocartago.renting.domain.PeliculaMayores18;
import com.videocartago.renting.domain.PeliculaTP;

public class FabricaPeliculaTipoFabricaConcreta1 extends PeliculaFabricaAbstracta{
	private static PeliculaTipoAbstracta peliculaAbs;
	@Override
	public PeliculaTipoAbstracta crearPelicula(Pelicula pelicula) {
		if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Terror")) {
			PeliculaMayores18 pelicula18 = new PeliculaMayores18(pelicula);
			pelicula18.setTipo();
			peliculaAbs= pelicula18;
		}else if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("suspenso")) {
		    PeliculaMayores12 peliculas12 = new PeliculaMayores12(pelicula);
			peliculas12.setTipo();
			peliculaAbs= peliculas12;
		}else {
			PeliculaTP peliculasTP = new PeliculaTP(pelicula);
			peliculasTP.setTipo();
			peliculaAbs= peliculasTP;
		}
		return peliculaAbs;
	}
	

}
