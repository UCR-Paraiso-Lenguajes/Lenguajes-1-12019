package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carreras {

	private static ArrayList<Carrera> carreras;

	public Carreras() {
		super();

		carreras = new ArrayList<Carrera>();
		ArrayList<Curso> cursos = new ArrayList<>();
		Curso IF01 = new Curso(1, "Teoria Organizacional", "IF01", 3, "Inicial", "I");
		Curso IF02 = new Curso(2, "Metodos de investigacion cualitativa", "IF02", 4, "Inicial", "I");
		Curso IF03 = new Curso(3, "Metodos de investigacion cuantitativa", "IF03", 3, "Inicial", "I");
		Curso IF04 = new Curso(4, "Economia aplicada a la gestion", "IF04", 4, "Inicial", "I");
		Curso IF05 = new Curso(5, "Taller de habilidades Gerenciales", "IF05", 2, "Inicial", "I");

		Curso IF06 = new Curso(6, "Bases Legales para la Gestion", "IF06", 5, "Intermedio", "II");
		Curso IF07 = new Curso(7, "Economia aplicada a la gestion II", "IF07", 2, "Intermedio", "II");
		Curso IF08 = new Curso(8, "Taller de habilidades Gerenciales II", "IF08", 2, "Intermedio", "II");

		Curso IF09 = new Curso(9, "Gestion Publica", "IF09", 3, "Intermedio", "III");
		Curso IF010 = new Curso(10, "Gestion Social", "IF010", 3, "Intermedio", "III");
		Curso IF011 = new Curso(11, "Gestion de Proyectos", "IF011", 4, "Intermedio", "III");

		Curso IF012 = new Curso(12, "Gestion Estrategica", "IF012", 4, "Intermedio", "IV");
		Curso IF013 = new Curso(13, "Taller de habilidades Gerenciales III", "IF013", 2, "Intermedio", "IV");

		Curso IF014 = new Curso(14, "Plan de Negocios", "IF014", 4, "Intermedio", "V");
		Curso IF015 = new Curso(15, "Seminario de Investigacion", "IF015", 3, "Intermedio", "V");
		Curso IF016 = new Curso(16, "Etica para la Gestion", "IF016", 2, "Intermedio", "V");

		Curso IF017 = new Curso(17, "Seminario de Investigacion III", "IF017", 4, "Final", "VI");
		Curso IF018 = new Curso(18, "Desarrollo y Resposabilidad Social", "IF018", 4, "Final", "VI");

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
		PlanDeEstudio planDeEstudio = new PlanDeEstudio(1, "CarreraInovadora");
		planDeEstudio.setCursos(cursos);
		Carrera carrera = new Carrera(1, "Carrera Inovadora");
		carrera.setPlanDeEstudio(planDeEstudio);
		carreras.add(carrera);
		// TODO Auto-generated constructor stub
	}

	public PlanDeEstudio obtenerPlanDeEstudio(int id) {
		PlanDeEstudio result = null;
		for (Carrera carreraGuardada : carreras) {
			if (carreraGuardada.getId() == id) {
				result = carreraGuardada.getPlanDeEstudio();
			}
		}
		return result;
	}

	public Carrera agregar(Carrera carrera) {
		carreras.add(carrera);
		return carrera;
	}

	public void eliminar(int id) {
		for (Carrera carreraGuardada : carreras) {
			if (carreraGuardada.getId() == id) {
				carreras.remove(carreraGuardada);
			}
		}
	}

	public void modificar(int id, Carrera carrera) {
		for (Carrera carreraGuardada : carreras) {
			if (carreraGuardada.getId() == id) {
				carreraGuardada = carrera;
			}
		}
	}
	
	public void actualizarPlan(int id, PlanDeEstudio planDeEstudio) {
		for (Carrera carreraGuardada : carreras) {
			if (carreraGuardada.getId() == id) {
				carreraGuardada.setPlanDeEstudio(planDeEstudio);
			}
		}
	}
}
