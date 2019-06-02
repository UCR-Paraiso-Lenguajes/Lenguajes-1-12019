package com.orbis.b62734.Laboratorio1Orbis.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62734.Laboratorio1Orbis.data.LibroDao;
import com.orbis.b62734.Laboratorio1Orbis.domain.Libro;



@Service
public class LibroBusiness {
	
	@Autowired
	private LibroDao libroDao;
	
	public List<Libro> encontrarLibro(int idEditorial){
		return libroDao.buscaLibros(idEditorial);
	}
}

