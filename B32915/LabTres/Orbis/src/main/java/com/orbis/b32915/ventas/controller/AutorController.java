package com.orbis.b32915.ventas.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b32915.ventas.business.AutorBusiness;
import com.orbis.b32915.ventas.data.AutorData;
import com.orbis.b32915.ventas.domain.Autor;

@Controller
public class AutorController {

	@Autowired
    AutorData autorData;
	
	@Autowired 
	AutorBusiness autorBusiness;
	
	@RequestMapping(value = "/mantenimientoAutores", method = RequestMethod.GET)
	public String mantenimientoAutores(Model model){
		
		Iterator<Autor> listaAutores = autorData.findAllAutores();
		
		model.addAttribute("listaAutores", listaAutores);
		
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value = "/editarAutor", method = RequestMethod.GET)
	public String editarAutor(Model model,@RequestParam("idAutor") int id){
		
		model.addAttribute("autor", autorBusiness.obtenerAutorPorId(id));
				
		return "editarAutor";
	}
	
	@RequestMapping(value = "/eliminarAutor", method = RequestMethod.GET)
	public String eliminarAutor(Model model,@RequestParam("idAutor") int id){
		
		model.addAttribute("autor", autorBusiness.obtenerAutorPorId(id));
				
		return "eliminarAutor";
	}

}
