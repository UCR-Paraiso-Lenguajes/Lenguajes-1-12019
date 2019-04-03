package com.videcartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videcartago.renting.data.GeneroData;
import com.videcartago.renting.domain.Genero;






@Service
public class GeneroBusiness {
	@Autowired
	private GeneroData generoDao;
	
	public List<Genero> findAll(){
		return generoDao.findAllGenres(0, 100);
	}
	

}


