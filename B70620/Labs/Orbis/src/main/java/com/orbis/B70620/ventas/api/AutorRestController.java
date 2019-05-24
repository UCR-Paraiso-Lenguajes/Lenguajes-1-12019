package com.orbis.B70620.ventas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.B70620.ventas.business.AutorBusiness;
import com.orbis.B70620.ventas.domain.Autor;

@RestController
public class AutorRestController {

	@Autowired
	private AutorBusiness autorBusinness;
	
	
	@RequestMapping(value = "/api/editarautor", method = RequestMethod.POST)
	public @ResponseBody void guardarAutor(@RequestBody Autor autor) {
		autorBusinness.editarAutor(autor);
	}
	
	@RequestMapping(value = "/api/eliminarautor", method = RequestMethod.POST)
	public @ResponseBody void eliminarAutor(@RequestBody Autor autor) {
		autorBusinness.eliminarAutor(autor);
	}
	
	
}
