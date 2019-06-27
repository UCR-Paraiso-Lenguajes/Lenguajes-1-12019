package com.orbis.B74560.business;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B74560.data.AutorData;
import com.orbis.B74560.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired // Inicializa
	private AutorData autorDao;

	public List<Autor> buscarAutor(int rangoInicio, int rangoFinal) {

		if (rangoInicio < rangoFinal) {
			return autorDao.buscarAutores(rangoInicio, rangoFinal);
		} else {
			return autorDao.buscarAutores(rangoFinal, rangoInicio);
		}// fin del if 

	}// fin del List<Autor> buscarAutores
	
	public Iterator<Autor> buscarAutorApellido(String apellidos_autor){

		return autorDao.searchPorAutorApellido(apellidos_autor);
		
	}
	
	public Iterator<Autor> buscarAutorId(int id_autor){

		return autorDao.buscarAutorId(id_autor);
		
	}
	
	public void actualizarAutor(int idAutor, Autor autor){
		
		autorDao.actualizarAutor(idAutor, autor);
	}

	
	public void borrarAutor(int idAutor){
		
		autorDao.borrarAutor(idAutor);
	}
}// fin de AutorBusiness 
