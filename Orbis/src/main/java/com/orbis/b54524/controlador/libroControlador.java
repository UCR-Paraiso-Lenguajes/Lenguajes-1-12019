package com.orbis.b54524.controlador;

import java.sql.SQLException;
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

import com.orbis.b54524.business.AutorBusiness;
import com.orbis.b54524.business.EditorialBusiness;
import com.orbis.b54524.business.LibroBusiness;
import com.orbis.b54524.datos.LibroForm;
import com.orbis.b54524.dominio.Autor;
import com.orbis.b54524.dominio.Editorial;
import com.orbis.b54524.dominio.Libro;

@Controller
public class libroControlador {
	
	@Autowired
	private EditorialBusiness editorialBusiness;
	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	public AutorBusiness autorBusiness;
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.GET)
	public String iniciar(Model model) {
		
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales(1, 10));
		return "ver_editoriales";
	}
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET)
	public String buscarPorEditorial(Model model, @RequestParam("idEditorial") int idEditorial) {
		model.addAttribute("libros", libroBusiness.listarLibros(1, 10, idEditorial));
		return "mostrar_libros";
	}
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String init(LibroForm libroForm, Model model) 
	{
		Iterator<Editorial> editoriales =  editorialBusiness.listarEditoriales(0, 50);
		Iterator<Autor> autores = autorBusiness.encontrarAutores();
		
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("form",new LibroForm());
		model.addAttribute("autores", autores);
	
		return "insertarLibro";
    }
	
	@RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws Exception 
	{
		if (bindingResult.hasErrors())
		{
			Iterator<Editorial> editoriales =  editorialBusiness.listarEditoriales(0, 50);
			Iterator<Autor> autores = autorBusiness.encontrarAutores();
			model.addAttribute("editoriales",editoriales);
			model.addAttribute("autores", autores);
			return "insertarLibro";
		}
		else
		{
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.setEditorial(new Editorial(libroForm.getIdEditorial()));
			libroBusiness.save(libro);
			
			model.addAttribute("libros", libroBusiness.save(libro));
			return "mostrar_libros";
		}
	}
}
