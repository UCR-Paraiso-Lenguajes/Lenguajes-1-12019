package com.orbis.b67156.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b67156.data.AutorData;
import com.orbis.b67156.domain.Autor;
@Service
public class AutorBusiness {
	
	@Autowired
	private AutorData autorData;
	
	public Iterator<Autor> findAutoresPorApellido(String apellidos){
		return autorData.buscarPorApellido(apellidos);
	}
	
	public Iterator<Autor> findAutoresPorId(int id){
		return autorData.buscarPorId(id);
	}
	
	public List<Autor> buscarAutores(int inicio, int fin){
		return autorData.buscarAutores(inicio, fin);
	}

	public void update(int idAutor, Autor autor) {
		autorData.update(idAutor,autor);
	}

	public void delete(int id) {
		autorData.delete(id);
		
	}

}
