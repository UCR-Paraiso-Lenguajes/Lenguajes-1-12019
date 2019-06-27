package com.orbis.b32915.ventas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.orbis.b32915.ventas.data.AutorData;
import com.orbis.b32915.ventas.data.EditorialData;
import com.orbis.b32915.ventas.data.LibroData;
import com.orbis.b32915.ventas.domain.Autor;
import com.orbis.b32915.ventas.domain.Editorial;
import com.orbis.b32915.ventas.domain.Libro;
import com.orbis.b32915.ventas.domain.form.LibroForm;

@Controller
public class LibroController {

	 @Autowired
	EditorialData editorialData;
	 
	 @Autowired
	LibroData libroData;
	 
	 @Autowired
    AutorData AutorData;
	 
	@RequestMapping(value = "/ver_editoriales", method = RequestMethod.GET)
	public String inicair(Model model){
		
		Iterator<Editorial> listaEditorial = editorialData.findEditorialByRange(1, 4);
		
		model.addAttribute("listaEditorial", listaEditorial);
		
		return "ver_editoriales";
	}
	
	@RequestMapping(value = "/mostrar_libros", method = RequestMethod.GET)
	public String buscarPorEditorial(Model model, @RequestParam("id") int id){

		Iterator<Libro> listaLibro = libroData.findLibroByEditorial(id);
		
		if(!libroData.findLibroByEditorial(id).hasNext()) {
			
		    String validacion = "No se tienen valores";
			model.addAttribute("vacio",validacion);
		
		}else{
			
			model.addAttribute("listaLibro", listaLibro);
		}
		
		return "mostrar_libros";
	}
	
	@RequestMapping(value = "/insertar_libro", method = RequestMethod.GET)
	public String insertarLibro(Model model){
     
		Iterator<Editorial> listaEditorial = editorialData.findEditorialByRange(1,100);
		model.addAttribute("listaEditorial", listaEditorial);
		
		Iterator<Autor> listaAutor = AutorData.findAllAutores();
		model.addAttribute("listaAutor", listaAutor);
		
		Iterator<Autor> listaAutoresFinales = null;
		model.addAttribute("listaAutorFinales", listaAutoresFinales);
		
		model.addAttribute("libroForm", new LibroForm());
		
		return "insertar_libro";
	}
	
	@RequestMapping(value = "/insertar_libro/salvar", method = RequestMethod.POST)
	public String saveBook(@Valid LibroForm libroForm,Model model) throws SQLException {
		
		try {
			libroData.addBook(libroForm);
			
			model.addAttribute("numLibro", libroForm.getId_libro());
			model.addAttribute("tituloLibro", libroForm.getTitulo());
			
			model.addAttribute("msg1", "Libro Insertado con exito");
			model.addAttribute("msg2", "Nombre: "+libroForm.getTitulo());
			model.addAttribute("msg3", "Codigo: "+libroForm.getId_libro());
			
		} catch (Exception e) {
			return "error";
		}	
		
		return "exito";
	}
  }
	

