package com.orbis.b67156.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b67156.data.LibroData;
import com.orbis.b67156.domain.Libro;

@Service
public class LibroBusiness {
	
	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> buscarPorId(int id_editorial) {
		return libroDao.buscarPorEditorial(id_editorial);
	}

}
