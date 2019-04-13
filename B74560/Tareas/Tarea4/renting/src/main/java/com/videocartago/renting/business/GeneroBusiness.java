package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.data.GeneroData;
import com.videocartago.renting.domain.Genero;

@Service
public class GeneroBusiness {

	@Autowired
	private GeneroData generoDao;

	public List<Genero> findAll(int inicioRango, int finRango) {

		return generoDao.findAllGeneres(inicioRango, finRango);

	}

}
