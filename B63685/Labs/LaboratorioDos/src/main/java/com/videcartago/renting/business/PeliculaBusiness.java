package com.videcartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videcartago.renting.data.PeliculaData;
import com.videcartago.renting.domain.Pelicula;

@Service
public class PeliculaBusiness {
	
	@Autowired
	private PeliculaData peliculaData;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String title, String genre) {
		return peliculaData.findMoviesByTitleAndGenre(title, genre);
	//se deberia devolver un iterator de peliculas
	}
	
	public Pelicula save(Pelicula pelicula) throws SQLException {
		return peliculaData.save(pelicula);
	}
	}


