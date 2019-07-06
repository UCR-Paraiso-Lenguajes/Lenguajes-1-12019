package ucr.ac.cr.planDeEstudios.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import ucr.ac.cr.planDeEstudios.business.PlanBusiness;
import ucr.ac.cr.planDeEstudios.domain.Curso;

@RestController
public class PlanControllerRest {
/*DADO QUE LAS CARRERAS UNIVERSITARIAS TIENEN SOLO UN PLAN DE ESTUDIOS, CREÉ UN API REST PARA LA UCR DONDE SE OFRECEN LOSMÉTODOS NECESARIOS PARA HACER
 * EL CRUD DE:PLANDEES TUDIOS Y CURSOSCON EL PREFIJO.../UCR/API/CARRERAS/{CARRERA}/...*/
	@Autowired
	private PlanBusiness planBusiness;
	//PARA PROBARLO EN POSTMAN http://localhost:8080/examen1B73331/api/ucr/carreras/cursos
	@RequestMapping(value="/api/ucr/carreras/cursos", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Curso> listarCursos(){
		return planBusiness.traeCursos();
	}
	@RequestMapping(value="/api/ucr/carreras/cursos/{nombreArea}/{nombreCiclo}", method=RequestMethod.POST)//@PathVariable String nombre,//
	public @ResponseBody void insertarCurso(@PathVariable String nombreArea,@PathVariable String nombreCiclo,@RequestBody Curso curso){
		 planBusiness.insertarCurso(nombreArea, nombreCiclo, curso);
	}
	@RequestMapping(value="/api/ucr/carreras/cursos/{nombreCurso}", method=RequestMethod.PUT)//@PathVariable String nombre,//
	public @ResponseBody void eliminarCurso(@PathVariable String nombreCurso){
		 planBusiness.eliminaCurso(nombreCurso);
	}
	@RequestMapping(value="/api/ucr/carreras/cursos/actualiza/{nombreCurso}", method=RequestMethod.PUT)//@PathVariable String nombre,//
	public @ResponseBody void actualizaCurso(@PathVariable String nombreCurso,@RequestBody Curso curso){
		 planBusiness.actualizaCurso(nombreCurso, curso);
	}
}
