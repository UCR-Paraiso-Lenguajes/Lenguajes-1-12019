package com.orbis.b63817.ventas.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.ventas.datos.PeliculaData;
import com.orbis.b63817.ventas.dominio.Pelicula;

@Service
public class PeliculaBusiness {
	
	@Autowired
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String title, String genre) {
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}

}
