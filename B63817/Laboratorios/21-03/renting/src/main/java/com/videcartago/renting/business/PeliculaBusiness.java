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
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String title, String genre) {
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}

}
