package com.orbis.B74560.business;

import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.B74560.data.LibroData;
import com.orbis.B74560.domain.Libro;


public class LibroBusiness {
	
	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> buscarPorEditorial(int id_editorial) {
		return libroDao.buscarPorEditorial( id_editorial);
	}

}
