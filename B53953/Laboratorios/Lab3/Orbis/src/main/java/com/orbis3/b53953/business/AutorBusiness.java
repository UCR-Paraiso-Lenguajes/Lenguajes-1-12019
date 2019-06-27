package com.orbis3.b53953.business;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis3.b53953.data.AutorData;
import com.orbis3.b53953.domain.Autor;


@Service
public class AutorBusiness {

	@Autowired
	private AutorData autorData;

	public java.util.List<Autor> obtenerAutores(String apellidos) {
		return autorData.buscarAutores(apellidos);
	}

	public Autor obtenerAutorPorId(int id) {
		return autorData.obtenerAutorPorId(id).get(0);
	}

	public void update(int id, Autor autor) {
		autorData.update(id , autor);
	}

	public void delete(int id) {
		autorData.delete(id);
	}
}