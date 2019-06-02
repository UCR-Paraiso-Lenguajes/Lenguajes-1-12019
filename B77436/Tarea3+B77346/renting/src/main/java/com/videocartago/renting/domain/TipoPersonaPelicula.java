package com.videocartago.renting.domain;

import com.videocartago.renting.factoryAbstract.PeliculaAbstract;
import com.videocartago.renting.tipoAbstract.TipoPersona_PeliculaAbstract;

public class TipoPersonaPelicula extends TipoPersona_PeliculaAbstract{

	@Override
	public PeliculaAbstract elegirTipoDeTelevidente(Pelicula pelicula) {
		
		
		if(pelicula.getGenero().getNombreGenero()==null) {
			throw new RuntimeException("El nombre de genero viene vacío");
		}else if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Terror")) {
			Mayores18Persona mayores18 = new Mayores18Persona(pelicula);
			mayores18.getTipo();
			return mayores18;
		}else if(pelicula.getGenero().getNombreGenero().equalsIgnoreCase("Suspenso")) {
			Mayores12Persona mayores12 = new Mayores12Persona(pelicula);
			mayores12.getTipo();
			return mayores12;
		}
		else {
			TodoPublicoPersona todoPublico = new TodoPublicoPersona(pelicula);
			todoPublico.getTipo();
			return todoPublico;
		}
	}

}
