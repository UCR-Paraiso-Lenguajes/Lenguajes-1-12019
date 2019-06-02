package com.orbis.b73331.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b73331.business.AutorBusiness;
import com.orbis.b73331.domain.Autor;

@RestController
public class AutorControllerRest {
	@Autowired
	private AutorBusiness autorBussiness;
	
	
	@RequestMapping(value="/api/autores", method=RequestMethod.GET)
	public @ResponseBody Iterator<Autor> listarAutores(@RequestParam(value="apellidos", defaultValue="Val") String apellidos){
		return autorBussiness.buscarAutoresPorApellidos(apellidos);
	}
	@RequestMapping(value="/api/autor/{id}", method=RequestMethod.PUT)
	public @ResponseBody void actualizarAutor(@PathVariable int id,
													@RequestBody Autor autor){
		autorBussiness.update(id, autor);
		
	}
	@RequestMapping(value="/api/autordelete/{id}", method=RequestMethod.PUT)
	public @ResponseBody void eliminarAutor(@PathVariable int id){
		autorBussiness.delete(id);
		
	}
	//http://localhost:8080/orbis/api/autores/?apellidos=Val
}
