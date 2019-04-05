package com.videocartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Pelicula;

@Service
public class PeliculaBusiness {
	@Autowired
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMovieByTitleAndGenre(String title, String genre){
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}
	
	public Pelicula save(Pelicula pelicula){
		return peliculaDao.save(pelicula);
	}
	
	public List<Pelicula> findAllMovieByTitle(String title){
		return peliculaDao.findMoviesByTitle(title);
	}
}
