package com.orbis3.b53953.ControllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis3.b53953.business.AutorBusiness;
import com.orbis3.b53953.domain.Autor;


@RestController
public class AutorControllerRest {

	@Autowired
	private AutorBusiness autorBusiness;	

	@RequestMapping(value="/api/editarAutor", method=RequestMethod.PUT )
	public @ResponseBody void actualizarAutor(
			@RequestBody Autor autor)
	{
		autorBusiness.update(autor.getId() , autor);
	}

	@RequestMapping(value="/api/eliminarAutor/{id}", method=RequestMethod.PUT )
	public @ResponseBody void eliminarAutor(
			@PathVariable int id )
	{
		autorBusiness.delete(id);
	}
}