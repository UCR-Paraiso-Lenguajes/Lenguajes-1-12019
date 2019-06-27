package com.orbis.b63685.Laboratorio1Orbis.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b63685.Laboratorio1Orbis.business.EditorialBusiness;
import com.orbis.b63685.Laboratorio1Orbis.business.LibroBusiness;
import com.orbis.b63685.Laboratorio1Orbis.domain.Libro;

@RestController
public class LibroControllerRest {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/api/libros", method=RequestMethod.GET )
	public @ResponseBody List<Libro> listarPeliculas2(
			
			@RequestParam(value="idEditorial", defaultValue="1") int idEditorial)
	{
		return libroBusiness.encontrarLibro(idEditorial);
	}
	
	
	
}

