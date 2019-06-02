package com.orbis.b73027.negocios;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b73027.data.AutorData;
import com.orbis.b73027.domain.Autor;



public class AutorNegocios {
	
	@Autowired
	private AutorData AutorDao;
	
	public List<Autor> buscarAutores(int inicio, int fin){

		return AutorDao.buscarAutores(inicio, fin);
		
	}
	
	public Iterator<Autor> searchPorAutorApellido(String apellidos_autor){

		return AutorDao.searchPorAutorApellido(apellidos_autor);
		
	}
	
		public void actualizarAutor(int idAutor, Autor autor){
				
			AutorDao.actualizarAutor(idAutor, autor);
			}
			
	public void delete(int idAutor){
		
		AutorDao.borrarAutor(idAutor);
	}
	
	public Iterator<Autor>  buscarAutorId(int id){
	
		return AutorDao.buscarAutorId( id);
		
	}
	
	
}
