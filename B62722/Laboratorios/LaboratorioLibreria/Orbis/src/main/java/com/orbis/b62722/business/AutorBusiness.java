package com.orbis.b62722.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62722.data.AutorData;
import com.orbis.b62722.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired
	private AutorData autorData;
	
	public List<Autor> buscarAutor() {
		return autorData.buscarAutor();
	}
}
