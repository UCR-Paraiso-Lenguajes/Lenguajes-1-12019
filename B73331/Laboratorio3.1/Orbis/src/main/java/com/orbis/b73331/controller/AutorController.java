package com.orbis.b73331.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b73331.business.AutorBusiness;
import com.orbis.b73331.data.AutorData;
import com.orbis.b73331.domain.Autor;

@Controller
public class AutorController {
	@Autowired
	private AutorBusiness autorBusiness;
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mantenimientoAutores";
	}
	@RequestMapping(value="/buscarAutorPorApellidos", method=RequestMethod.POST )
	public String buscarAutoresPorApellidos(Model model,@RequestParam("apellidos") String apellidos) {
		Iterator<Autor> autores = autorBusiness.buscarAutoresPorApellidos(apellidos);
		model.addAttribute("autores", autores);
		return "mantenimientoAutores";
	}
	@RequestMapping(value="/buscarAutorPorApellidos", method=RequestMethod.GET )
	public String buscarAutoresPorApellidosGet(Model model,@RequestParam("apellidos") String apellidos) {
		Iterator<Autor> autores = autorBusiness.buscarAutoresPorApellidos(apellidos);
		model.addAttribute("autores", autores);
		return "mantenimientoAutores";
	}
	@RequestMapping(value="/editarAutor", method=RequestMethod.GET )
	public String editar(Model model,@RequestParam("id") int id) {
		Autor autor = autorBusiness.encuentraAutor(id);
		model.addAttribute("autor",autor);
		return "editarAutor";
	}
	@RequestMapping(value="/borrarAutor", method=RequestMethod.GET )
	public String borrar(Model model,@RequestParam("id") int id) {
		Autor autor = autorBusiness.encuentraAutor(id);
		model.addAttribute("autor",autor);
		return "borrarAutor";
	}
}
