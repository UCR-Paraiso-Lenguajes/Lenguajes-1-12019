package com.videoparaiso.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoparaiso.renting.data.PeliculaData;
import com.videoparaiso.renting.domain.Pelicula;

@Service
public class PeliculaBusiness {

	@Autowired
	private PeliculaData peliculaData;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String title, String genre) {
		return peliculaData.findAllMoviesByTitleAndGenre(title, genre);
	}
	
	public Pelicula save(Pelicula pelicula) throws SQLException {
		return peliculaData.save(pelicula);
	}
}
