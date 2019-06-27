package com.orbis.b73331.business;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b73331.data.EditorialData;
import com.orbis.b73331.domain.Editorial;




@Service
public class EditorialBusiness {
	@Autowired
	private EditorialData editorialData;
	
	public Iterator<Editorial> buscarPorRango(int desde, int hasta) {
		if(desde>hasta) {
			return editorialData.buscarPorRango(hasta, desde);
		}
		return editorialData.buscarPorRango(desde, hasta);
	}
	public Iterator<Editorial> buscarPorId(int idEditorial) {
		return editorialData.buscarPorId(idEditorial);
	}
}
