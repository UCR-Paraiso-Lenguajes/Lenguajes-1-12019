package com.videocartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;

@Service
public class PeliculaBusiness {
	
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	@Autowired
	private PeliculaData peliculaDao;
	
	public List<Pelicula> findAllMoviesByTitleAndGenre(String title, String genre) {
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}
	
	public Pelicula save(Pelicula pelicula) throws SQLException {
		if(pelicula == null) throw new RuntimeException("id pelicula es requerida");
		if(pelicula.getTitulo().length() > 200) throw new RuntimeException("El nombre no puede tener mas de 200 caractes");
		if(pelicula.getGenero()==null) throw new RuntimeException("El genero es requerido");
		return peliculaDao.save(pelicula);
	}
	
	public Genero codGenero(int cod_genero) {
		List<Genero> genero = peliculaDao.obtenerNombreGenero(cod_genero);
		System.out.println(genero.get(0));
		return genero.get(0);
	}

}
