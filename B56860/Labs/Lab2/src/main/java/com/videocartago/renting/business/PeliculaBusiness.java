package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Pelicula;

@Service
public class PeliculaBusiness {

	@Autowired
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String titulo, String genero) {
		return peliculaDao.findMoviesByTitleAndGenre(titulo, genero);
	}

}
