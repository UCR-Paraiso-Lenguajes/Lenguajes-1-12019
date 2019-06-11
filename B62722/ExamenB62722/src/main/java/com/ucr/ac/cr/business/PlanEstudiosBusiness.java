package com.ucr.ac.cr.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ucr.ac.cr.domain.Curso;
import com.ucr.ac.cr.domain.PlanEstudios;

@Service
public class PlanEstudiosBusiness {
	
	private PlanEstudios planEstudios = new PlanEstudios();
	private List<Curso> listaCursos  = new ArrayList<Curso>();
	
	public PlanEstudiosBusiness() {
		listaCursos.add(new Curso("Teoria organizacional", "TO", "V", 3));
		listaCursos.add(new Curso("Metodos de investigacion cualitativa", "MI1","V", 4));
		listaCursos.add(new Curso("Metodos de investigacion cualitativa", "MI2","V", 3));
		listaCursos.add(new Curso("Economia aplicada a la gestion", "EAG","V", 4));
		listaCursos.add(new Curso("Taller de habilidades gerenciales", "THG","V", 2));
		
		listaCursos.add(new Curso("Bases legales para la gestión", "BLG","VI", 5));
		listaCursos.add(new Curso("Economia aplicada a la gestion II", "EAG2","VI", 4));
		listaCursos.add(new Curso("Taller de habilidades gerenciales", "THG","VI", 2));
		
		listaCursos.add(new Curso("Gestion publica", "GP", "VII",3));
		listaCursos.add(new Curso("Gestion social", "GS","VII", 3));
		listaCursos.add(new Curso("Gestion de proyectos", "GP","VII", 4));
		
		listaCursos.add(new Curso("Gestion estrategica", "GE", "VIII",4));
		listaCursos.add(new Curso("Taller de habilidades gerenciales III", "THG3","VIII", 2));
		
		listaCursos.add(new Curso("Plan de negocios", "PN", "IX",4));
		listaCursos.add(new Curso("Seminario de investigacion", "SI","IX", 3));
		listaCursos.add(new Curso("Etica para la gestion", "EG", "IX",2));
		
		listaCursos.add(new Curso("Seminario de investigacion II", "SI2", "X",4));
		listaCursos.add(new Curso("Desarrollo y responsabilidad social", "DRS", "X",3));
		
		planEstudios.setListaCursos(listaCursos);
	}
	
	public List<Curso> mostrarPlanEstudios() {
		return listaCursos;
	}
	
	public int mostrarCantidadCursos(List<Curso> listaCursos) {
		return listaCursos.size();
	}
	
	public int mostrarCantidadCreditos(List<Curso> listaCursos) {
		int creditos = 0;
		for (int i = 0; i < listaCursos.size(); i++) {
			creditos += listaCursos.get(i).getCreditos();
		}
		return creditos;
	}
	
	public void añadirCurso(Curso curso) {
		planEstudios.getListaCursos().add(curso);
	}
	
	public boolean añadirCursoConRequisito(Curso curso, List<Curso> cursosRequisito) {
		boolean añadido = false;
		if (curso.getCiclo().equalsIgnoreCase("V")) {
			throw new RuntimeException("Los cursos iniciales no pueden tener requisitos.");
		} else {
			for (int j = 0; j < cursosRequisito.size(); j++) {
				if (cursosRequisito.get(j).getCiclo().equalsIgnoreCase("X")) {
					throw new RuntimeException("Uno de los cursos no puede ser requisito.");
				} else {
					planEstudios.getListaCursos().add(curso);
					añadido = true;
				}
			}
		}

		return añadido;
	}
	
	public int calcularCursosRequeridos(Curso curso) {
		int cantidadCursos = 0;
		if (curso.getCursosRequisito().isEmpty()) {
			return cantidadCursos;
		} else {
			return curso.getCursosRequisito().size();
		}
	}
	
	public void eliminarCurso(String nombre, Curso curso) {
		for (int i = 0; i < listaCursos.size(); i++) {
			if(listaCursos.get(i).getNombre().equals(nombre)) {
				listaCursos.remove(curso);
			}
		}
	}
	
	public void actualizarCurso(String nombre, Curso curso) {
		for (int i = 0; i < listaCursos.size(); i++) {
			if(listaCursos.get(i).getNombre().equals(nombre)) {
				//
			}
		}
	}
}
