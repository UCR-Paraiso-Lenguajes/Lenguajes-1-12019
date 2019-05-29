package ucr.ac.cr.Controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import ucr.ac.cr.dominio.Curso;
import ucr.ac.cr.dominio.PlanEstudios;
import ucr.ac.cr.logica.CursoLogica;
import ucr.ac.cr.logica.PlanEstudiosLogica;

public class CarreraControladorRest {

	@Autowired
	private CursoLogica cursoLogica;
	@Autowired
	private PlanEstudiosLogica planLogica;

	@RequestMapping(value = "ucr/api/carrera/planEstudios/cursos/{sigla}", method = RequestMethod.PUT)
	public @ResponseBody void actualizarCurso(@PathVariable String sigla, @RequestBody Curso curso) {

		cursoLogica.actualizar(sigla, curso);
	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios/cursos", method = RequestMethod.POST)
	public @ResponseBody void insertarCurso(@RequestBody Curso curso, HttpServletRequest servlet) {

		cursoLogica.insertarCurso(curso);
	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios/cursos/{sigla}", method = RequestMethod.GET)
	public @ResponseBody Curso mostrarCurso(@RequestParam(value = "sigla", defaultValue = "IF201") String sigla) {

		return cursoLogica.mostrarCursoPorSigla(sigla);

	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios/cursos/{sigla}", method = RequestMethod.DELETE)
	public @ResponseBody void borrarCurso(@PathVariable int sigla, @RequestBody Curso curso) {

		cursoLogica.delete(sigla);
	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios{nombre}", method = RequestMethod.PUT)
	public @ResponseBody void actualizarPlanDeEstudios(@PathVariable String nombre,
			@RequestBody PlanEstudios planEstudio) {

		planLogica.actualizarPlanEstudios(nombre, planEstudio);
	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios", method = RequestMethod.POST)
	public @ResponseBody void insertarPlan(@RequestBody PlanEstudios planEstudios, HttpServletRequest servlet) {

		planLogica.insertarPlanEstudios(planEstudios);
	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios/{nombre}", method = RequestMethod.GET)
	public @ResponseBody Curso mostrarPlanEstudidos(
			@RequestParam(value = "nombre", defaultValue = "IF201") String sigla) {

		return planLogica.mostrarCursoPorNombre();

	}

	@RequestMapping(value = "ucr/api/carrera/planEstudios/{nombre}", method = RequestMethod.DELETE)
	public @ResponseBody void borrarPlanEstudios(@PathVariable String nombre, @RequestBody PlanEstudios planEstudios) {
		planLogica.delete(nombre);

	}

}
