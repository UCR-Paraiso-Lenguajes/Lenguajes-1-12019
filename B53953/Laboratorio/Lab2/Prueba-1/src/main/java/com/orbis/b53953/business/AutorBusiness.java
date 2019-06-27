package com.orbis.b53953.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b53953.data.AutorData;
import com.orbis.b53953.domain.Autor;


@Service
public class AutorBusiness {
	
	@Autowired
	private AutorData autorData;

	public List<Autor> encontrarAutores() {
		return autorData.encontrarAutores();
	}
}
