package com.orbis.b73027.negocios;

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
}
