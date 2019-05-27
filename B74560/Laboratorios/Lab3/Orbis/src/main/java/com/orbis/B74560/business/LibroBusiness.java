package com.orbis.B74560.business;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B74560.data.LibroData;
import com.orbis.B74560.domain.Libro;
import com.orbis.B74560.domain.LibroAutor;

@Service
public class LibroBusiness {

	@Autowired
	private LibroData libroDao;

	public Iterator<Libro> buscarPorEditorial(int idEditorial) {
		return libroDao.buscarPorEditorial(idEditorial);
	}

	public void guardarLibroAutor(Libro libro, LibroAutor libroAutor) {
		libroDao.guardarLibro(libro, libroAutor);
	}
	
}
