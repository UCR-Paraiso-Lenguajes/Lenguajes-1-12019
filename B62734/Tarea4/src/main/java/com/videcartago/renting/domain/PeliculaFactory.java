package com.videcartago.renting.domain;

import java.util.List;

public class PeliculaFactory {


	public Pelicula clasificar(Pelicula pelicula) {
		Genero genero = pelicula.getGenero();
		if(genero instanceof Suspenso) {
			pelicula=new PeliculaMayor12(pelicula.getDuracion(), pelicula.getDescripcion(), pelicula.getCodPelicula(), pelicula.getTitulo(), pelicula.getTotalPeliculas(), pelicula.isSubtitulada(), pelicula.isEstreno(), pelicula.getGenero(), pelicula.getActores());
		} else if(genero instanceof Terror) {
			pelicula=new PeliculaMayor18(pelicula.getDuracion(), pelicula.getDescripcion(), pelicula.getCodPelicula(), pelicula.getTitulo(), pelicula.getTotalPeliculas(), pelicula.isSubtitulada(), pelicula.isEstreno(), pelicula.getGenero(), pelicula.getActores());
		} else  {
			pelicula=new PeliculaTodoPublico(pelicula.getDuracion(), pelicula.getDescripcion(), pelicula.getCodPelicula(), pelicula.getTitulo(), pelicula.getTotalPeliculas(), pelicula.isSubtitulada(), pelicula.isEstreno(), pelicula.getGenero(), pelicula.getActores());
		}
		return pelicula;
	}


}
