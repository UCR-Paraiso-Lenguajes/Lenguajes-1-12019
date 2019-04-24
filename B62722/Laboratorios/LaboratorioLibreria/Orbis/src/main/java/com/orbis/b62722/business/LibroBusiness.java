package com.orbis.b62722.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62722.data.LibroData;
import com.orbis.b62722.domain.Libro;

@Service
public class LibroBusiness {

	@Autowired
	private LibroData libroData;
	
	public List<Libro> buscarLibro(int id_editorial) {
		return libroData.buscarLibro(id_editorial);
	}
}
