package com.orbis.b63817.ventas.controlador;

import java.util.Iterator;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63817.ventas.dominio.Autor;
import com.orbis.b63817.ventas.dominio.Editorial;
import com.orbis.b63817.ventas.dominio.Libro;
import com.orbis.b63817.ventas.logica.AutorLogica;
import com.orbis.b63817.ventas.logica.EditorialLogica;

@Controller
public class AutorControlador {
	@Autowired
	private AutorLogica autorBusiness;

	@RequestMapping(value = "/mantenimientoAutores", method = RequestMethod.GET)
	public String listarEditoriales(Model model) {
		Iterator<Autor> listaAutor = autorBusiness.mostrarAutores();
		model.addAttribute("listaAutor", listaAutor);

		return "mantenimientoAutores";
	}

	@RequestMapping(value = "/editarAutor", method = RequestMethod.GET)
	public String editarAutor(Model model, @RequestParam("id_autor") int id_autor) {
		Autor autor = autorBusiness.consultaAutorPorID(id_autor);
			model.addAttribute("autor", autor);
		

		return "/editarAutor";
	}
	
	@RequestMapping(value = "/borrarAutor", method = RequestMethod.GET)
	public String borrarAutor(Model model, @RequestParam("id_autor") int id_autor) {
		Autor autor = autorBusiness.consultaAutorPorID(id_autor);
			model.addAttribute("autor", autor);
		

		return "/borrarAutor";
	}

}
