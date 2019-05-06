package com.orbis.B77436.business;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B77436.data.EditorialData;
import com.orbis.B77436.domain.Editorial;

@Service
public class EditorialBusiness {
	
	@Autowired
	private EditorialData editorialDao;
	
	public Iterator<Editorial> buscarId(int id_editorial) {
		if(id_editorial < 0) {
			throw new RuntimeException("El dato es inválido");
		}
		return editorialDao.buscarPorId(id_editorial);
	}
	
	public Iterator<Editorial> buscarExtrato(int rango1, int rango2){
		if(rango1>rango2) {
			int aux=rango1;
			rango1=rango2;
			rango2=aux;
			return editorialDao.buscarPorExtracto(rango1, rango2);
		}else if(rango1 < 0 || rango2<0) {
			throw new RuntimeException("Los datos son inválidos");
		}
		return editorialDao.buscarPorExtracto(rango1, rango2);
	}

}
