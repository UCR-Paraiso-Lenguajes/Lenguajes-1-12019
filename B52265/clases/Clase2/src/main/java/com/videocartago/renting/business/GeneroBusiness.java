package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.dao.GeneroDao;
import com.videocartago.renting.domain.Genero;

@Service
public class GeneroBusiness {
	@Autowired
	private GeneroDao generoDao;

	public List<Genero> findAll(int inicio, int ultimo) {
		return generoDao.findAllGenres(inicio, ultimo);
	}
}
