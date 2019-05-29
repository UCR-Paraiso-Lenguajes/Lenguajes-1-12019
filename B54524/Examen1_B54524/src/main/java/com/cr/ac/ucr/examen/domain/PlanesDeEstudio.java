package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlanesDeEstudio {

	private static ArrayList<PlanDeEstudio> carreras;

	public PlanesDeEstudio() {
		super();

		carreras = new ArrayList<PlanDeEstudio>();
		ArrayList<Curso> cursos = new ArrayList<>();
		Curso IF01 = new Curso("Teoria Organizacional", "IF01", 3, "Inicial");
		Curso IF02 = new Curso("Metodos de investigacion cualitativa", "IF02", 4, "Inicial");
		Curso IF03 = new Curso("Metodos de investigacion cuantitativa", "IF03", 3, "Inicial");
		Curso IF04 = new Curso("Economia aplicada a la gestion", "IF04", 4, "Inicial");
		Curso IF05 = new Curso("Taller de habilidades Gerenciales", "IF05", 2, "Inicial");

		Curso IF06 = new Curso("Bases Legales para la Gestion", "IF06", 5, "Intermedio");
		Curso IF07 = new Curso("Economia aplicada a la gestion II", "IF07", 2, "Intermedio");
		Curso IF08 = new Curso("Taller de habilidades Gerenciales II", "IF08", 2, "Intermedio");

		Curso IF09 = new Curso("Gestion Publica", "IF09", 3, "Intermedio");
		Curso IF010 = new Curso("Gestion Social", "IF010", 3, "Intermedio");
		Curso IF011 = new Curso("Gestion de Proyectos", "IF011", 4, "Intermedio");

		Curso IF012 = new Curso("Gestion Estrategica", "IF012", 4, "Intermedio");
		Curso IF013 = new Curso("Taller de habilidades Gerenciales III", "IF013", 2, "Intermedio");

		Curso IF014 = new Curso("Plan de Negocios", "IF014", 4, "Intermedio");
		Curso IF015 = new Curso("Seminario de Investigacion", "IF015", 3, "Intermedio");
		Curso IF016 = new Curso("Etica para la Gestion", "IF016", 2, "Intermedio");

		Curso IF017 = new Curso("Seminario de Investigacion III", "IF017", 4, "Final");
		Curso IF018 = new Curso("Desarrollo y Resposabilidad Social", "IF018", 4, "Final");

		IF018.agregarRequisito(IF016);
		IF017.agregarRequisito(IF015);
		IF013.agregarRequisito(IF08);
		IF08.agregarRequisito(IF05);
		IF017.agregarRequisito(IF015);
		IF015.agregarRequisito(IF06);
		IF015.agregarRequisito(IF07);
		IF06.agregarRequisito(IF02);
		IF06.agregarRequisito(IF03);
		IF06.agregarRequisito(IF04);
		IF07.agregarRequisito(IF02);
		IF07.agregarRequisito(IF03);
		IF07.agregarRequisito(IF04);
		IF014.agregarRequisito(IF012);
		IF012.agregarRequisito(IF09);
		IF012.agregarRequisito(IF010);
		IF012.agregarRequisito(IF011);
		IF09.agregarRequisito(IF01);
		IF010.agregarRequisito(IF01);
		IF011.agregarRequisito(IF01);
		cursos.add(IF01);
		cursos.add(IF02);
		cursos.add(IF03);
		cursos.add(IF04);
		cursos.add(IF05);
		cursos.add(IF06);
		cursos.add(IF07);
		cursos.add(IF08);
		cursos.add(IF09);
		cursos.add(IF010);
		cursos.add(IF011);
		cursos.add(IF012);
		cursos.add(IF013);
		cursos.add(IF014);
		cursos.add(IF015);
		cursos.add(IF016);
		cursos.add(IF017);
		cursos.add(IF018);
		PlanDeEstudio planDeEstudio = new PlanDeEstudio("CarreraInovadora", cursos, "Informatica");
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Curso> obtenerPlanesDeEstudio(String carrera) {
		ArrayList<Curso> result = new ArrayList<Curso>();
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				result = planDeEstudio.getCursos();
			}
		}
		return result;
	}

	public PlanDeEstudio agregar(PlanDeEstudio planDeEstudio) {
		carreras.add(planDeEstudio);
		return planDeEstudio;
	}

	public void eliminar(String carrera) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				carreras.remove(planDeEstudio);
			}
		}
	}

	public void modificar(String carrera, PlanDeEstudio plan) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				planDeEstudio = plan;
			}
		}
	}

	public void agregarCursosAPlan(ArrayList<Curso> cursos, String carrera) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				planDeEstudio.setCursos(cursos);
			}
		}
	}

	public void agregarCurso(String carrera, Curso curso) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				planDeEstudio.getCursos().add(curso);
			}
		}
	}

	public void modificarCurso(String carrera, Curso curso) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				for (Curso cursoModificar : planDeEstudio.getCursos()) {
					if (cursoModificar.getSigla().equals(curso.getSigla())) {
						cursoModificar = curso;
					}
				}
			}
		}
	}
	
	public void eliminarCurso(String carrera, Curso curso) {
		for (PlanDeEstudio planDeEstudio : carreras) {
			if (planDeEstudio.getCarrera().equals(carrera)) {
				for (Curso cursoEliminar : planDeEstudio.getCursos()) {
					if (cursoEliminar.getSigla().equals(curso.getSigla())) {
						planDeEstudio.getCursos().remove(cursoEliminar);
					}
				}
			}
		}
	}
	
	

}
