package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Pelicula;

@Controller
public class PeliculaBusiness {
	
	@Autowired
	private PeliculaData peliculaData;
	
	public List<Pelicula> findMoviesByTimeAndGenre(String title, String genero){
		return peliculaData.findMoviesByTimeAndGenre(title, genero);
	}
}
