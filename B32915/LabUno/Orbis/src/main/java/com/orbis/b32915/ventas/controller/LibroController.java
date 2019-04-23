package com.orbis.b32915.ventas.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b32915.ventas.data.EditorialData;
import com.orbis.b32915.ventas.data.LibroData;
import com.orbis.b32915.ventas.domain.Editorial;
import com.orbis.b32915.ventas.domain.Libro;

@Controller
public class LibroController {

	 @Autowired
	EditorialData editorialData;
	 
	 @Autowired
	LibroData libroData;
	 
	@RequestMapping(value = "/ver_editoriales", method = RequestMethod.GET)
	public String inicair(Model model){
		
		Iterator<Editorial> listaEditorial = editorialData.findEditorialByRange(1, 4);
		
		model.addAttribute("listaEditorial", listaEditorial);
		
		return "ver_editoriales";
	}
	
	@RequestMapping(value = "/mostrar_libros", method = RequestMethod.GET)
	public String buscarPorEditorial(Model model, @RequestParam("id") int id){

		Iterator<Libro> listaLibro = libroData.findLibroByEditorial(id);

		model.addAttribute("listaLibro", listaLibro);
		
		return "mostrar_libros";
	}
	
	
}
