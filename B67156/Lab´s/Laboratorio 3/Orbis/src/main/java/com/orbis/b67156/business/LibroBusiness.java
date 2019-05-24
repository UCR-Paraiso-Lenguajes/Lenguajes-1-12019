package com.orbis.b67156.business;

import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b67156.data.LibroData;
import com.orbis.b67156.domain.Libro;
import com.orbis.b67156.domain.Libro_Autor;


public class LibroBusiness {
	
	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> findAllMoviesByTitleAndGenre(int idEditorial) {
		return libroDao.searchPorEditorial( idEditorial);
	}
	public void guardarLibro(Libro libro, Libro_Autor libroAutor) {
		libroDao.guardarLibro(libro, libroAutor);
	}

}
