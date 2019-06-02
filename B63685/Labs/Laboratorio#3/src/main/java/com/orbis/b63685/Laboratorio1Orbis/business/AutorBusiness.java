package com.orbis.b63685.Laboratorio1Orbis.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63685.Laboratorio1Orbis.data.AutorDao;
import com.orbis.b63685.Laboratorio1Orbis.domain.*;

@Service
public class AutorBusiness {

	@Autowired
	private AutorDao autorData;

	public List<Autor> buscarAutor() {
		return autorData.buscarAutores();
	}

	public List<Autor> findAuthorByLastName(String lastName) {

		return autorData.findAuthorByLastName(lastName);

	}

	public List<Autor> listAuthors() {

		return autorData.listAuthors();
	}

	public void delete(int autorId) {

		autorData.delete(autorId);

	}

	public void update(int id, Autor autor) {

		autorData.update(id, autor);

	}
	
	public List<Autor> findAuthorById(int idAutor) {

		return autorData.findAuthorById(idAutor);

	}

}
