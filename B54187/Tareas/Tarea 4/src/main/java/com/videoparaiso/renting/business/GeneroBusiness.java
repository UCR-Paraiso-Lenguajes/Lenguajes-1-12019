package com.videoparaiso.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoparaiso.renting.data.GeneroData;
import com.videoparaiso.renting.domain.Genero;

@Service
public class GeneroBusiness {

	@Autowired
	private GeneroData generoData;
	
	public List<Genero> findAll() {
		return generoData.findAllGenres();
	}
}
