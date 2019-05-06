package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.videocartago.renting.dao.PeliculaDao;
import com.videocartago.renting.domain.Pelicula;
@Service
public class PeliculaBusiness {
	@Autowired
	private PeliculaDao peliculaDao;

	public List<Pelicula>findMoviesByTittleAndGender(String titulo,String genero){
		return peliculaDao.findMoviesByTittleAndGenre(titulo, genero);
	}
	public List<Pelicula>peliculas(){
		return peliculaDao.peliculas();
	}
	
	public Pelicula save(Pelicula pelicula) {
		if(pelicula== null) throw new RuntimeException("la pelicula es requerida");
		if(pelicula.getTitulo().length()> 200) throw new RuntimeException("El nombre no puede tener mas de 200 caracteres");
		if(pelicula.getGenero() == null) throw new RuntimeException("El genero es requerido");
		return peliculaDao.save(pelicula);
	}
}
