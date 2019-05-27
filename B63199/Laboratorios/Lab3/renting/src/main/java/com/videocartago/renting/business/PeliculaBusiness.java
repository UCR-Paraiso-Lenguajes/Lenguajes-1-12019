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
		//Validar el tipo de publico en TP, M12 y M18
		//Si el genero es Terror la película debe ser para mayores de 18, si el genero es suspenso la película 
		//debe ser para mayores de 12 y cualquier otro serían TP. 10pts
		if(pelicula.getGenero().equals("Terror"))
			pelicula.setTipoPublico("M18");
		else if(pelicula.getGenero().equals("Suspenso"))
			pelicula.setTipoPublico("M12");
		else
			pelicula.setTipoPublico("TP");
			
		return peliculaDao.save(pelicula);
	}
	
	public List<Pelicula> findAllMovieByTitle(String title){
		return peliculaDao.findMoviesByTitle(title);
	}
}
