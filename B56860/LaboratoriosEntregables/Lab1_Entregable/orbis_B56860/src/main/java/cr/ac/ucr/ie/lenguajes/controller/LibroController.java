package cr.ac.ucr.ie.lenguajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.ac.ucr.ie.lenguajes.business.LibroBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Controller

public class LibroController {
	
	@Autowired
	LibroBusiness libroBusiness;
	
	@RequestMapping(value="/ver_libros",method=RequestMethod.GET)
	public @ResponseBody String iniciar(Model model) {
		List<Libro> libros=libroBusiness.ListarLibros(1, 3);
		model.addAttribute("libros", libros);
		return "mostrarLibros";
	}
}
