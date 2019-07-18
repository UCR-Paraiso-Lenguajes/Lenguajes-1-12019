package com.orbis.b53953.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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

import com.orbis.b53953.business.AutorBusiness;
import com.orbis.b53953.business.EditorialBusiness;
import com.orbis.b53953.business.LibroBusiness;
import com.orbis.b53953.data.LibroForm;
import com.orbis.b53953.domain.Autor;
import com.orbis.b53953.domain.Editorial;
import com.orbis.b53953.domain.Libro;



@Controller
public class LibroController {
	
	@Autowired
	public LibroBusiness libroBusiness;
	
	@Autowired
	public EditorialBusiness editorialBusiness;
	
	@Autowired
	public AutorBusiness autorBusiness;
	
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String init(LibroForm libroForm, Model model) 
	{
		List<Editorial> editoriales =  editorialBusiness.encontrarEditoriales();
		List<Autor> autores = autorBusiness.encontrarAutores();

		
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("autores",autores);
		model.addAttribute("form",new LibroForm());
	
		return "insertarLibro";
    }
	
	
	@RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException 
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("editoriales", editorialBusiness.encontrarEditoriales());
			model.addAttribute("autores", autorBusiness.encontrarAutores());
			return "insertarLibro";
		}
		else
		{
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.setEditorial(new Editorial(libroForm.getIdEditorial(), "","",""));
			System.out.println(libroForm.toString());
			for (int i = 0; i < libroForm.getAutores().length; i++) {
				System.out.println(libroForm.toString());
				Autor autor = new Autor();
				System.out.println(libroForm.toString());
				autor.setIdAutor(libroForm.getAutores()[i]);
				System.out.println(libroForm.toString());
				libro.getAutores().add(autor);
				System.out.println(autor.toString());
				System.out.println(libroForm.toString());
			}
			Libro libroInsertado = libroBusiness.save(libro);
			System.out.println(libroForm.toString());
        if(libroInsertado != null) {
			return "exito";
        }
        else {
        return "error";
        }
		}
	}

}
