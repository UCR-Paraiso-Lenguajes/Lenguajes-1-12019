package com.orbis.b63685.Laboratorio1Orbis.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orbis.b63685.Laboratorio1Orbis.business.AutorBusiness;
import com.orbis.b63685.Laboratorio1Orbis.business.LibroBusiness;
import com.orbis.b63685.Laboratorio1Orbis.domain.Autor;

@RestController
public class AutorControllerRest {

	@Autowired
	private AutorBusiness autorBusiness;
	@Autowired
	
	
	@RequestMapping(value="/api/getAutor", method=RequestMethod.GET)
	public ResponseEntity<Object> getDataAutor() {
		

		//model.addAttribute("datosAutor", autorBusiness.findAuthorById(idAutor));	
		List<Autor> findAuthor= autorBusiness.findAuthorById(1234567890);
		//System.out.print(autorBusiness.findAuthorById());
				//return autorBusiness.findAuthorById(3);
				
		return new ResponseEntity<>(findAuthor.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/editarAutor", method=RequestMethod.POST)
	public ResponseEntity<Object> postDataAutor(@RequestBody  Autor autor) {
		

		//model.addAttribute("datosAutor", autorBusiness.findAuthorById(idAutor));
		//System.out.print(autorBusiness.findAuthorById(1234567890));
		//return autorBusiness.findAuthorById(3);
		
		autorBusiness.update(autor.getIdAutor(), autor);
		
		System.out.print(autor.getIdAutor()+""+ autor);
		//List<Autor> findAuthor= autorBusiness.findAuthorById(1234567890);
		
		return new ResponseEntity<>("Exito", HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/api/borrarAutor", method=RequestMethod.DELETE)
	public ResponseEntity<Object> borrarDataAutor(@RequestBody  Autor autor) {
			
		autorBusiness.delete(autor.getIdAutor());
		System.out.print(autor.getIdAutor());
		return new ResponseEntity<>("Exito", HttpStatus.OK);
	}
	

}
