package com.orbis.b73331.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b73331.business.AutorBusiness;
import com.orbis.b73331.business.EditorialBusiness;
import com.orbis.b73331.business.LibroBusiness;
import com.orbis.b73331.domain.Autor;
import com.orbis.b73331.domain.Editorial;
import com.orbis.b73331.domain.Libro;
import com.orbis.b73331.domain.LibroAutor;
import com.orbis.b73331.form.LibroForm;

@Controller
public class LibroController {
	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private AutorBusiness autorBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/findLibro", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "findLibro";
	}
	@RequestMapping(value="/findLibro2", method=RequestMethod.GET )
	public String buscarPorId(Model model, @RequestParam("id") int id) {
		model.addAttribute("libros", libroBusiness.buscarPorIdEditorial(id));
		return "findLibro";
	}
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET )
	public String insertarLibro(LibroForm libroForm, Model model) {
		List<Autor> autores = autorBusiness.encuentraAutores(0, 999999);
		Iterator<Editorial> editoriales = editorialBusiness.buscarPorRango(0, 999999);
		model.addAttribute("autores",autores);
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("libroForm", new LibroForm());
		
		return "insertarLibro";
	}
	@RequestMapping(value="/insertarLibro", method=RequestMethod.POST )
	public String insertarLibroP(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
		
			List<Autor> autores = autorBusiness.encuentraAutores(0, 999999);
			Iterator<Editorial> editoriales = editorialBusiness.buscarPorRango(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
			model.addAttribute("libroForm", libroForm);
			return "insertarLibro";
			
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
			LibroAutor libroAutor = new LibroAutor(libro.getId_libro(), getListInt(libroForm.getAutoresS()));
			libroBusiness.guardarLibroAutor(libro, libroAutor);
			
			List<Autor> autores = autorBusiness.encuentraAutores(0, 999999);
			Iterator<Editorial> editoriales = editorialBusiness.buscarPorRango(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
			return "insertarLibro";
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
