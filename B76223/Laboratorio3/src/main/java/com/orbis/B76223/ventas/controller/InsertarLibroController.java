package com.orbis.B76223.ventas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.B76223.ventas.business.AutorBusiness;
import com.orbis.B76223.ventas.business.EditorialBusiness;
import com.orbis.B76223.ventas.business.LibroBusiness;
import com.orbis.B76223.ventas.domain.Autor;
import com.orbis.B76223.ventas.domain.Editorial;
import com.orbis.B76223.ventas.domain.Libro;
import com.orbis.B76223.ventas.form.LibroForm;

@Controller
public class InsertarLibroController {

	@Autowired
	private AutorBusiness autorBusiness; 
	@Autowired
	private LibroBusiness libroBusiness; 
	@Autowired
	private EditorialBusiness editorialBusiness; 
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String init(LibroForm insertarLibroForm, Model model) 
	{
		List<Autor> autores =  autorBusiness.findAllAutores(0, 9999999);
		List<Editorial> editoriales = editorialBusiness.listarEditorial(0, 9999999);
		
		model.addAttribute("autores",autores);
		model.addAttribute("editoriales", editoriales);
	    model.addAttribute("form", new LibroForm());
	    
	    
		return "insertarLibro";
    }
	
	@RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
	public String save(@Valid LibroForm insertarLibroForm, BindingResult bindingResult, Model model) throws SQLException 
	{
		if (bindingResult.hasErrors())
		{
			
			return init(insertarLibroForm, model);
		}
		else
		{
			Libro libro = new Libro();
			//List<Autor> idAutoresList = new LinkedList<Autor>();
			
			//parametros la fuente y destino 
			BeanUtils.copyProperties(insertarLibroForm, libro);
			
			// convertir la lista de String en una lista de id
			String[] autoresId= insertarLibroForm.getIdAutor();
			for(int i =0; i<autoresId.length; i++) {
				libro.getAutores().add(new Autor(Integer.parseInt(autoresId[i])));
			}
			
			libro.getEditorial().setIdEditorial(insertarLibroForm.getIdEditorial());
			Libro libroInsertado = libroBusiness.saveLibroAutor(libro);
			
			return exito(model, libroInsertado.getIdLibro(), libroInsertado.getTitulo());
		}
	}
	
	@RequestMapping(value="/exito", method=RequestMethod.POST)
    public String exito(Model model, int idLibro, String titulo){
		
		model.addAttribute("titulo", titulo);
		model.addAttribute("idLibro", idLibro);
		
		return "exito";
	} 
	
}
