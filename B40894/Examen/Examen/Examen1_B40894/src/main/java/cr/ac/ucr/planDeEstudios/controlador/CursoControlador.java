package cr.ac.ucr.planDeEstudios.controlador;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import cr.ac.ucr.planDeEstudios.negocios.CursoNegocios;


@Controller
public class CursoControlador {

	
	@Autowired
	private CursoNegocios cursoNegocios;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET )
	public String listarCursos(Model model) {
		model.addAttribute("cursos", cursoNegocios.listarCursos());
		return "listarCursos.html";
	}
}
