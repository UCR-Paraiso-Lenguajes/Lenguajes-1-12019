package com.orbis.b67156.controller;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.b67156.business.AutorBusiness;
import com.orbis.b67156.domain.Autor;

//@RestController
@Controller
public class AutorController {
	
	@Autowired
	private AutorBusiness autorBusiness;
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.POST)
	public String mantenimientoAutores (Model model, @RequestParam("apellido") String apellido) {
		Iterator<Autor> autores = autorBusiness.findAutoresPorApellido(apellido);
		model.addAttribute("autores", autores);
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value="/editarAutor", method=RequestMethod.GET )
    public String editar(Model model,@RequestParam("idAutor") int idAutor) {
        model.addAttribute("autores",autorBusiness.findAutoresPorId(idAutor).next());
        return "editarAutor";
    }
	
	@RequestMapping(value="/eliminarAutor", method=RequestMethod.GET )
    public String eliminarAutor(Model model,@RequestParam("idAutor") int idAutor) {
        model.addAttribute("autores",autorBusiness.findAutoresPorId(idAutor).next());
        return "eliminarAutor";
    }
	
	
	@RequestMapping(value= "/api/editarAutor/{id}",method=RequestMethod.PUT)
	public @ResponseBody void editarAutor (
			@PathVariable int id,
			@RequestBody Autor autor) throws SQLException
	{
		autorBusiness.update(id,autor);
	}
	
	@RequestMapping(value= "/api/eliminarAutor/{id}",method=RequestMethod.DELETE)
	public @ResponseBody void eliminarAutor (
			@PathVariable int id) throws SQLException
	{
		autorBusiness.delete(id);
	}

}
