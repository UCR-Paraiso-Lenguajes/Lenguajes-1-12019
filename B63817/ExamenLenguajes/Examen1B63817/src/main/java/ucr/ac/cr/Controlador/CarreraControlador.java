package ucr.ac.cr.Controlador;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import ucr.ac.cr.dominio.Curso;
import ucr.ac.cr.logica.CarreraLogica;

@Controller
public class CarreraControlador {


	

	@RequestMapping(value = "/listarCursos", method = RequestMethod.GET)
	public String listarCursos(Model model) {
		CarreraLogica carreraLogica= new CarreraLogica();
		Iterator<Curso> listaCurso = carreraLogica.listarCursos();
		
		model.addAttribute("listaCurso", listaCurso);

		return "listarCursos";
	}
}
