package com.orbis.B74560.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B74560.business.*;

@Controller
public class AutorController {
	
	@Autowired
	private AutorBusiness autorBusiness;
	
	@RequestMapping(value = "/verAutores", method = RequestMethod.GET)
	public String iniciar(Model model) {
		
		return "mantenimientoAutores";
	}

	@RequestMapping(value="/verAutores", method=RequestMethod.POST )
	public String mostrar_libros(Model model, @RequestParam("apellidos_autor")String apellidos_autor){
		String apellidos_autorTemp = apellidos_autor;
		model.addAttribute("autor", autorBusiness.buscarAutorApellido(apellidos_autorTemp));
		return "mantenimientoAutores";
	}
	
	@SuppressWarnings("unused")
	private List<Integer> getListInt(String[] listFromWeb){
		
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < listFromWeb.length; i++) {
			lista.add(Integer.parseInt(listFromWeb[i]));
		}
		return lista;
		
	}
	
	/*----------------------------Editar---------------------------------*/

	@RequestMapping(value = "/editarAutor", method = RequestMethod.GET)
	public String editarAutor(Model model,
			@RequestParam("id_autor") int idAutor) {
		
		model.addAttribute("autor", autorBusiness.buscarAutorId(idAutor).next());
		
		return "editarAutor";
		
	}

	@RequestMapping(value = "/borrarAutor", method = RequestMethod.GET)
	public String borrarAutor(Model model,
			@RequestParam("id_autor") int idAutor) {
		
		model.addAttribute("autor", autorBusiness.buscarAutorId(idAutor).next());
		
		return "borrarAutor";
		
	}
	
	
	
	
}
