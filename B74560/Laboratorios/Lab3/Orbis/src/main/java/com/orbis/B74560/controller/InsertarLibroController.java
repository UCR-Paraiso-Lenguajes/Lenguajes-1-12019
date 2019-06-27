package com.orbis.B74560.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.B74560.business.AutorBusiness;
import com.orbis.B74560.business.EditorialBusiness;
import com.orbis.B74560.business.LibroBusiness;
import com.orbis.B74560.domain.Autor;
import com.orbis.B74560.domain.Editorial;
import com.orbis.B74560.domain.Libro;
import com.orbis.B74560.domain.LibroAutor;
import com.orbis.B74560.form.LibroForm;

@Controller
public class InsertarLibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private AutorBusiness autorBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET )
	public String insertarLibro(LibroForm libroForm, Model model) {
		List<Autor> autores = autorBusiness.buscarAutor(0, 999999);
		Iterator<Editorial> editoriales = editorialBusiness.buscarEditorialRango(0, 999999);
		model.addAttribute("autores",autores);
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("libroForm", new LibroForm());
		
		return "insertarLibro";
	}
	@RequestMapping(value="/insertarLibro", method=RequestMethod.POST )
	public String insertarLibroP(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
		
			List<Autor> autores = autorBusiness.buscarAutor(0, 999999);
			Iterator<Editorial> editoriales = editorialBusiness.buscarEditorialRango(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
			model.addAttribute("libroForm", libroForm);
			return "Error";
			
		}else {
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.setId_editorial(libroForm.getId_editorial());
			libro.setTitulo(libroForm.getTitulo());
			libro.setAno((short)libroForm.getAno());
			libro.setId_libro(libroForm.getId_libro());
			//////Cambiar esto  despues
			libro.setPrecio(libroForm.getPrecio());
			//////La lista de autores viene vacia
			LibroAutor libroAutor = new LibroAutor(libro.getId_libro(), getListInt(libroForm.getAutor()));
			libroBusiness.guardarLibroAutor(libro, libroAutor);
			
			List<Autor> autores = autorBusiness.buscarAutor(0, 999999);
			Iterator<Editorial> editoriales = editorialBusiness.buscarEditorialRango(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
			return "Correcto";
		}
		
	}
	private List<Integer> getListInt(String[] listFromWeb){
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < listFromWeb.length; i++) {
			lista.add(Integer.parseInt(listFromWeb[i]));
		}
		return lista;
		
	}
	

}
