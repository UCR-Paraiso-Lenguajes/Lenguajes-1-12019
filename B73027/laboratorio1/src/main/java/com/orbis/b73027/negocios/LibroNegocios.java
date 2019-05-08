package com.orbis.b73027.negocios;

import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b73027.data.LibroData;
import com.orbis.b73027.domain.Libro;


public class LibroNegocios {
	
	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> findAllMoviesByTitleAndGenre(int idEditorial) {
		return libroDao.searchPorEditorial( idEditorial);
	}

}
