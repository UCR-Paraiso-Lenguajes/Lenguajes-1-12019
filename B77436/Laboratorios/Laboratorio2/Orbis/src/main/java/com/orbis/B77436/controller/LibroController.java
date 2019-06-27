package com.orbis.B77436.controller;

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

import com.orbis.B77436.business.AutorBusiness;
import com.orbis.B77436.business.EditorialBusiness;
import com.orbis.B77436.business.LibroBusiness;
import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;
import com.orbis.B77436.form.LibroForm;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	@Autowired
	private AutorBusiness autorBusiness;
	
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mostrar_libros";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.GET )
	public String mensajeError(Model model) {
		return "error";
	}
	
	@RequestMapping(value="/exito", method=RequestMethod.GET )
	public String mensaje(Model model, Libro libro) {
		model.addAttribute("libro",libro);
		return "exito";
	}
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String iniciarLibro(LibroForm libroForm, Model model) throws SQLException 
	{
		Iterator<Editorial> publicador= editorialBusiness.findIdsEditorial();// =  libroBusiness.buscarId(9);//findAll(1, 9999999);
		Iterator<Autor> autores = autorBusiness.buscarAutores(); 
		model.addAttribute("publicador",publicador);
		model.addAttribute("autores", autores);
		model.addAttribute("form",new LibroForm());
		return "insertarLibro";
    }
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.POST )
	public String insertarLibroP(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException {
		if(bindingResult.hasErrors()) {
		
			Iterator<Editorial> publicador= editorialBusiness.findIdsEditorial();// =  libroBusiness.buscarId(9);//findAll(1, 9999999);
			Iterator<Autor> autores = autorBusiness.buscarAutores(); 
			model.addAttribute("publicador",publicador);
			model.addAttribute("autores", autores);
			model.addAttribute("form",new LibroForm());

			return "insertarLibro";
			
		}else {
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.setId_editorial(libroForm.getPublicador());
			libro.setTitulo(libroForm.getTitulo());
			libro.setAno(libroForm.getAño());
			libro.setId_libro(Integer.parseInt(libroForm.getIsbn()));
			libro.setPrecio(libroForm.getPrecio());
			Libro_Autor libroAutor = new Libro_Autor(libro.getId_libro(), obtenerListaAutores(libroForm.getAutores()));
			
			if(libro.getId_editorial()==0 || libroForm.getAutores().size()<=0)
				return mensajeError(model);
			libroBusiness.saveLibro(libro, libroAutor);
			
			//Iterator<Editorial> publicador= editorialBusiness.findIdsEditorial();// =  libroBusiness.buscarId(9);//findAll(1, 9999999);
			//Iterator<Autor> autores = autorBusiness.buscarAutores(); 
			//model.addAttribute("publicador",publicador);
			//model.addAttribute("autores", autores);

			//return "insertarLibro";
			return mensaje(model, libro);
		}
		
	}
	private List<Integer> obtenerListaAutores(List<String> listaAutores){
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < listaAutores.size(); i++) {
			lista.add(Integer.parseInt(listaAutores.get(i)));
		}
		return lista;
	}
	
	
	
	@RequestMapping(value="/mostrar_libros2", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial") String id_editorialRequest) {
		int id_editorial = Integer.parseInt(id_editorialRequest);
		model.addAttribute("libro", libroBusiness.buscarId(id_editorial));
		return "mostrar_libros";
	}
	

	

}
