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
	
	public List<Pelicula> findAllMoviesByTitleAndGenere(String titulo, String genero) {
		
		return peliculaDao.findMoviesByTitleAndGenre(titulo, genero);
		
	}
	
	public Pelicula save(Pelicula pelicula) throws SQLException {
		
		if(pelicula == null) throw new RuntimeException("La identificación de película es requerido");
		if(pelicula.getTitulo().length() > 200) throw new RuntimeException("El campo de "
				+ "texto tiene un limite de 200 carateres");
		if(pelicula.getGenero()==null) throw new RuntimeException("El nombre de genero es requerido");
		
		return peliculaDao.save(pelicula);
		
	}

}
