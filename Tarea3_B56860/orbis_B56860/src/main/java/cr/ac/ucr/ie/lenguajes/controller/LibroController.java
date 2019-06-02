package cr.ac.ucr.ie.lenguajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cr.ac.ucr.ie.lenguajes.business.LibroBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Controller

public class LibroController {
	
	private int inicio=1;
	private int fin=3;
	
	
	
	@Autowired
	LibroBusiness libroBusiness;
	
	@RequestMapping(value="/ver_libros",method=RequestMethod.POST)
	public String iniciar(Model model) {
		List<Libro> libros=libroBusiness.ListarLibros(inicio, fin);
		model.addAttribute("libros", libros);
		return "mostrarLibros";
	}
	
	@RequestMapping(value="/siguiente",method=RequestMethod.GET)
	public String siguiente(Model model) {
		inicio+=3;
		fin+=3;
		List<Libro> libros=libroBusiness.ListarLibros(inicio, fin);
		model.addAttribute("libros", libros);
		return "mostrarLibros";
	}
	
	@RequestMapping(value="/anterior",method=RequestMethod.GET)
	public String anterior(Model model) {
		inicio-=3;
		fin-=3;
		List<Libro> libros=libroBusiness.ListarLibros(inicio, fin);
		model.addAttribute("libros", libros);
		return "mostrarLibros";
	}
}
