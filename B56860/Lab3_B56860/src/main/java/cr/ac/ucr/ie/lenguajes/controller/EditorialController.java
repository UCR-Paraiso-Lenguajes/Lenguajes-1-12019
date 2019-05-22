package cr.ac.ucr.ie.lenguajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.ie.lenguajes.business.EditorialBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Editorial;
import cr.ac.ucr.ie.lenguajes.domain.Libro;
@Controller
public class EditorialController {
	@Autowired
	EditorialBusiness editorialBusiness;
	
	private int inicio=1;
	private int fin=3;
	
	
	@RequestMapping(value="/ver_libros",method=RequestMethod.GET)
	public String librosporEdi(Model model, @RequestParam("id") int id) {
		List<Libro> libros= editorialBusiness.ListarLibrosPorEditorial(id);
		model.addAttribute("libros", libros);
		model.addAttribute("vacio", libros.isEmpty());
		return "mostrarLibros";
	}
	
	
	@RequestMapping(value="/editoriales",method=RequestMethod.GET)
	public String iniciar(Model model) {
		List<Editorial> editoriales = editorialBusiness.ListarEditoriales(inicio, fin);
		model.addAttribute("editoriales",editoriales);
		return "verEditoriales";
	}
	
	@RequestMapping(value="/sig",method=RequestMethod.GET)
	public String sigiente(Model model) {
		inicio+=3;
		fin+=3;
		List<Editorial> editoriales = editorialBusiness.ListarEditoriales(inicio, fin);
		model.addAttribute("editoriales",editoriales);
		return "verEditoriales";
	}
	@RequestMapping(value="/ant",method=RequestMethod.GET)
	public String anterior(Model model) {
		inicio-=3;
		fin-=3;
		List<Editorial> editoriales = editorialBusiness.ListarEditoriales(inicio, fin);
		model.addAttribute("editoriales",editoriales);
		return "verEditoriales";
	}
}