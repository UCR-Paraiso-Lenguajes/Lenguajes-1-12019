package com.orbis.b73331.business;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b73331.data.LibroData;
import com.orbis.b73331.domain.Libro;



@Service
public class LibroBusiness {
	@Autowired
	private LibroData libroData;
	
	public Iterator<Libro> buscarPorIdEditorial(int idEditorial) {
		return libroData.buscarPorIdEditorial(idEditorial);
	}
}
