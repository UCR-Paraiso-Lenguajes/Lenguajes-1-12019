package com.orbis.B77436.business;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B77436.data.EditorialData;
import com.orbis.B77436.data.LibroData;
import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;

@Service
public class LibroBusiness {

	@Autowired
	private LibroData libroDao;
	
	public Iterator<Libro> buscarId(int id_editorial) {
		if(id_editorial<0) {
			throw new RuntimeException("El id editorial posee un valor inválido");
		}
		return libroDao.buscarPorId(id_editorial);
	}
	
	public void saveLibro(Libro libro, Libro_Autor libroAutor) {
		libroDao.save(libro, libroAutor);
	}
}
