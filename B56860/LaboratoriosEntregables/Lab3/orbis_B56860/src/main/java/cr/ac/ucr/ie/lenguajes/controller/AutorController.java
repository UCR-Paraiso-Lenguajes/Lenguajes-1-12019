package cr.ac.ucr.ie.lenguajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.ie.lenguajes.business.AutorBusiness;

@Controller
public class AutorController {
	@Autowired
	AutorBusiness autorBusiness;
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.GET)
	public String iniciar(Model model) {
		model.addAttribute("autores", autorBusiness.buscarAutor());
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.POST)
	public String buscarPorApellido(Model model, @RequestParam("apellido") String apellido) {
		if(apellido.trim().equals("")) {
			
			return "mantenimientoAutores";
		}
		else {	
		model.addAttribute("autores", autorBusiness.ListarAutoresPorApellido(apellido));
		return "mantenimientoAutores";
		}
	}
	
	
	@RequestMapping(value="/editarAutor", method=RequestMethod.GET )
	public String editarAutor(Model model,@RequestParam("idAutor")int idAutor)
	{		
		model.addAttribute("autor", autorBusiness.buscarAutorId(idAutor));
		
		return "editarAutor";
	}	
	
	@RequestMapping(value="/eliminarAutor", method=RequestMethod.GET )
	public String eliminarAutor(Model model,@RequestParam("idAutor")int idAutor)
	{
		model.addAttribute("autor", autorBusiness.buscarAutorId(idAutor));
		return "eliminarAutor";
	}	

}
