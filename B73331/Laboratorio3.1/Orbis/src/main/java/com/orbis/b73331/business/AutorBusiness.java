package com.orbis.b73331.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b73331.data.AutorData;
import com.orbis.b73331.domain.Autor;
@Service
public class AutorBusiness {
	@Autowired
	private AutorData autorData;
	
	public List<Autor> encuentraAutores(int inicio, int fin){
		if(inicio>fin) {
			return autorData.encuentraAutores(fin,inicio);
		}
		return autorData.encuentraAutores(inicio, fin);
	}
	public Iterator<Autor> buscarAutoresPorApellidos(String apellidos) {
		return autorData.buscarAutoresPorApellidos(apellidos);
	}
	public void update(int id, Autor autor) {
		autorData.update(id, autor);
	}
	public void delete(int id) {
		autorData.delete(id);
	}
	public Autor encuentraAutor(int id) {
		return autorData.encuentraAutor(id);
	}
}
