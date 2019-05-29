package com.orbis.b62734.Laboratorio1Orbis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b62734.Laboratorio1Orbis.business.AutorBusiness;
import com.orbis.b62734.Laboratorio1Orbis.domain.Autor;

@RestController
public class AutorControllerRest {
	@Autowired
	private AutorBusiness autorBusiness;	

 	@RequestMapping(value="/api/editarAutor", method=RequestMethod.PUT )
	public @ResponseBody void actualizarAutor(
			@RequestBody Autor autor)
	{
		autorBusiness.actualizarAutor(autor.getIdAutor() ,autor);
	}



 	@RequestMapping(value="/api/eliminarAutor/{id}", method=RequestMethod.PUT )
	public @ResponseBody void eliminarAutor(
			@PathVariable int id )
	{
		autorBusiness.eliminarAutor(id);
	}
	@RequestMapping(value="/api/buscarAutor/{apellido}", method=RequestMethod.PUT )
	public @ResponseBody void buscarAutor(
			@PathVariable String apellido)
	{
		autorBusiness.buscarAutorApellido(apellido);
	}
}
