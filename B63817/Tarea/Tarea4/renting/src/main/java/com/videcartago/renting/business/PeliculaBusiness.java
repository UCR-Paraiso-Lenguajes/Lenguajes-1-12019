package com.videcartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videcartago.renting.data.PeliculaData;
import com.videcartago.renting.domain.Pelicula;
import com.videcartago.renting.domain.PeliculaDisponible;
import com.videcartago.renting.domain.PeliculaRentada;

@Service
public class PeliculaBusiness {
	

	
	@Autowired
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMovieByTitleAndGenre(String title, String genre){
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}
	
	public Pelicula save(Pelicula pelicula){
		if(pelicula == null) throw new RuntimeException("La pelicula es requerida");
	    if(pelicula.getTitulo().length()>200) throw new RuntimeException("El titulo es muy largo");
		if(pelicula.getGenero() == null) throw new RuntimeException("El genero requerida");
		return peliculaDao.save(pelicula);
	}
	
	public void rentar(Pelicula pelicula) {
	if(pelicula.getEstadoPelicula() instanceof PeliculaRentada)  throw new RuntimeException("La pelicula ya está rentada");
	peliculaDao.Rentar(pelicula);
	}
	public void devolver(Pelicula pelicula) {
	if(pelicula.getEstadoPelicula() instanceof PeliculaDisponible)  throw new RuntimeException("La pelicula ya se encuentra en stock");
	peliculaDao.devolver(pelicula);	
	}

}
