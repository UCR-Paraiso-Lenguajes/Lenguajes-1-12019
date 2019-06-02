package com.orbis.B77436.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.B77436.business.AutorBusiness;
import com.orbis.B77436.domain.Autor;


@RestController
public class AutorControllerRest {
	
	@Autowired
	private AutorBusiness autorBusiness;
	
	@RequestMapping(value="/api/editarAutor/{id}", method=RequestMethod.PUT )
	public @ResponseBody void update(@PathVariable int id, @RequestBody Autor autor) {
		if(id==0 ) throw new RuntimeException("El id viene vacío");
		autorBusiness.update(id,autor);
	}
	
	
	
	
	@RequestMapping(value="/api/borrarAutor/{id}", method=RequestMethod.PUT )
	public @ResponseBody void delete(@PathVariable int id) {
		if(id==0) throw new RuntimeException("El id viene vacío");
		autorBusiness.delete(id);
	}

}
