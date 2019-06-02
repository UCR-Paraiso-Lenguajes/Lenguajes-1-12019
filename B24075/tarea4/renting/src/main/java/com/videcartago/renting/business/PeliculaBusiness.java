package com.videcartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videcartago.renting.data.GeneroData;
import com.videcartago.renting.data.PeliculaData;
import com.videcartago.renting.domain.Pelicula;

@Service
public class PeliculaBusiness 
{
	
	@Autowired
	private PeliculaData peliculaDao;
	@Autowired
	private GeneroData generoData;
	
	public List<Pelicula> findAllMoviesByTitleAndGender(String title, String genre) {
		return peliculaDao.findMoviesByTitleAndGenre(title, genre);
	}
	
	@Transactional
	public Pelicula save(Pelicula pelicula)
	{
		if(pelicula == null) throw new RuntimeException("La pelicula es requerida.");
		if(pelicula.getTitulo().length() > 200 ) throw new RuntimeException("El nombre no puede tener más de 200 caracteres.");
		if(pelicula.getGenero() == null ) throw new RuntimeException("El genero es requerido.");
			
		return peliculaDao.save(pelicula);
	}

	public void update(int id, Pelicula pelicula) 
	{
		if(pelicula == null) throw new RuntimeException("La pelicula es requerida.");
		if(pelicula.getTitulo().length() > 200 ) throw new RuntimeException("El nombre no puede tener más de 200 caracteres.");
		if(pelicula.getGenero() == null ) throw new RuntimeException("El genero es requerido.");
			
		peliculaDao.update(id , pelicula);
	}

}
