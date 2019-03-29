package com.orbis.B52265.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B52265.dao.EditorialDao;
import com.orbis.B52265.dao.LibroDao;
import com.orbis.B52265.domain.Editorial;
import com.orbis.B52265.domain.Libro;
@Service
public class LibroBusiness {
	@Autowired
	private LibroDao libro;

	public List<Libro> getLibros(int id) {
		return libro.getLibros(id);
	}
}
