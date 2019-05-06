package com.videocartago.renting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.data.GeneroData;

@Service
public class GeneroBusiness {
	@Autowired
	private GeneroData generoData;
	
	public List<Genero> findAll(int inicio, int fin){
		return generoData.findAllGenres(inicio, fin);
	}
}