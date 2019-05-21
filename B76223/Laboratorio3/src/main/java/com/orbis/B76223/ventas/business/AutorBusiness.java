package com.orbis.B76223.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orbis.B76223.ventas.data.AutorData;
import com.orbis.B76223.ventas.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired
	private AutorData autorData;
	
	public List<Autor> findAllAutores(int inicio, int fin){
		
		return autorData.findAllAutores(inicio, fin);
		
	}
	
	public List<Autor> findAutoresByLastName (String lastName){
		
		return autorData.findAutoresByLastName(lastName);
	}
	
public List<Autor> findAutoresById (int idAutor){
		
		return autorData.findAutoresById(idAutor);
	}
	
	public void updateAutor (int idAutor, Autor autor) {
		
		 autorData.updateAutores(idAutor, autor);
		
	}
	
	public void deleteAutor (int idAutor) {
		
		autorData.deleteAutor(idAutor);
		
	}
	
	
}
