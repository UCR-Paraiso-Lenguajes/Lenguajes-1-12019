package com.orbis.B77436.business;

import java.sql.SQLException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B77436.data.AutorData;
import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Libro;

@Service
public class AutorBusiness {
	
	@Autowired
	private AutorData autorData;
	
	public Iterator<Autor> buscarAutores() throws SQLException {
		return autorData.findAutores();
	}
	
	public Iterator<Autor> findAutorId(int id_autor) throws SQLException {
		return autorData.findAutorId(id_autor);
	}
	
	
	public Iterator<Autor> findApellidosAutor(String apellidosAutor) throws SQLException{
		return autorData.findApellidosAutores(apellidosAutor);
	}
	
	public void update(int id, Autor autor) {
		autorData.update(id, autor);
	}
	
	public void delete(int id_autor) {
		autorData.delete(id_autor);
	}

}
