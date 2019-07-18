package com.orbis.b40894.ventas.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b40894.ventas.data.LibroData;
import com.orbis.b40894.ventas.domain.Libro;

public class LibroBusiness {
	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> findLibroByEditorial(int idEditorial) {
		return libroDao.findLibroByEditorial(idEditorial);
	}
}
