package com.orbis.b67156.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b67156.data.AutorData;
import com.orbis.b67156.domain.Autor;

public class AutorBusiness {
	
	@Autowired
	private AutorData AutorDao;
	
	public List<Autor> buscarAutores(int inicio, int fin){

		return AutorDao.buscarPorBloque(inicio, fin);
		
	}


}
