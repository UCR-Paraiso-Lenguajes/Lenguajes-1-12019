package com.orbis.b32915.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b32915.ventas.business.AutorBusiness;
import com.orbis.b32915.ventas.domain.Autor;

@RestController
public class RestAutor {

	@Autowired
	AutorBusiness autorBusiness;
	
	@RequestMapping(value="/api/autores/{id}", method=RequestMethod.PUT )
	public @ResponseBody void actualizarAutor(
			@PathVariable int id , 
			@RequestBody Autor autor)
	{
		
		System.out.println("id ->"+id+" autor->"+autor.toString());
		autorBusiness.update(id , autor);
	}
	
	@RequestMapping(value="/api/autores/{id}", method=RequestMethod.DELETE )
	public @ResponseBody void eliminarAutor(
			@PathVariable int id){
		System.out.println("id ->"+id);
		autorBusiness.delete(id);
	}
	
	
}
