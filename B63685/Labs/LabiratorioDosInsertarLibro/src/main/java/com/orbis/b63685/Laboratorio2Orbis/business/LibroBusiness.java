package com.orbis.b63685.Laboratorio2Orbis.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63685.Laboratorio2Orbis.data.LibroDao;
import com.orbis.b63685.Laboratorio2Orbis.domain.Libro;



@Service
public class LibroBusiness {
	
	@Autowired
	private LibroDao libroDao;
	
	public List<Libro> encontrarLibro(int idEditorial){
		return libroDao.buscaLibros(idEditorial);
	}
}

