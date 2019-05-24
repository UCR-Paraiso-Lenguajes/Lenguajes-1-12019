package com.orbis.B76223.ventas.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.B76223.ventas.business.AutorBusiness;
import com.orbis.B76223.ventas.domain.Autor;

@RestController
public class AutoresController2 {

	@Autowired
	private AutorBusiness autorBusiness; 
	
	@RequestMapping(value = "/api/editarAutor", method = RequestMethod.PUT)
	public @ResponseBody void editarAutor(@RequestBody Autor autor) {
		
		autorBusiness.updateAutor(autor.getIdAutor(), autor);
		
	}
	
	@RequestMapping(value = "/api/eliminarAutor/{id}", method = RequestMethod.PUT)
	public @ResponseBody void eliminarAutor(@PathVariable int idAutor) {
		
		autorBusiness.deleteAutor(idAutor);
		
	}
	
}
