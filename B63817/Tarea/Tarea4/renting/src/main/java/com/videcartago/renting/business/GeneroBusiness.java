package com.videcartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videcartago.renting.data.GeneroData;
import com.videcartago.renting.domain.Genero;

@Service
public class GeneroBusiness
{
	@Autowired
	private GeneroData generoData;
	
	public List<Genero> findAll(int inicio, int fin) 
	{
		return generoData.findAllGenres(inicio, fin);
	}

}


