package com.orbis.b53953.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b53953.data.LibroData;
import com.orbis.b53953.domain.Libro;

@Service
public class LibroBusiness {

	@Autowired
	private LibroData libroData;
	
	public Libro save(Libro libro) throws SQLException{
		return libroData.save(libro);
	}
}

