package com.ucr.ac.cr.planDeEstudios.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.ac.cr.planDeEstudios.data.PlanDeEstudiosData;
import com.ucr.ac.cr.planDeEstudios.domain.Curso;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

@Service
public class PlanDeEstudioBusiness {

	
	private PlanDeEstudiosData planDao;
	private List<Curso> totalCursos;

	

	public PlanDeEstudioBusiness() {
		super();
		totalCursos = new ArrayList<Curso>();
		
	}

	public List<Curso> calculaPrerequisitos(Curso curso) {

		return planDao.calculaPrerequisitos(curso);
	}

	public boolean insertarPlanEstudio(PlanDeEstudios planDeEstudio) {

		return planDao.insertarPlanEstudio(planDeEstudio);
	}

	public void editarPlan(PlanDeEstudios planDeEstudios) {

		planDao.editarPlan(planDeEstudios);

	}

	public void delete(int idPlan) {

		planDao.delete(idPlan);
	}

	public int cantidadCreditos(ArrayList<Curso> cursos) {

		return planDao.cantidadCreditos(cursos);
	}

	public int cantidadCursos(ArrayList<Curso> cursos) {

		return planDao.cantidadCursos(cursos);

	}
	

	public List<Curso> datosPlanDeEstudio() {

		Curso curso1 = new Curso(1, "Teoria Organizacional", "TO", 3, true);
		Curso curso2 = new Curso(2, "Metodos de investigacion Cualitativa", "MIC", 3, true);
		Curso curso3 = new Curso(3, "Economía aplicada a la gestión", "EAG", 3, true);
		Curso curso4 = new Curso(4, "Taller de habilidades gerenciales", "THG", 3, true);

		Curso curso5 = new Curso(5, "Bases legales para la gestión", "BLG", 5, curso2, false);

		Curso curso6 = new Curso(6, "Economia aplicada a la gestión ll", "EAGII", 4, curso2, false);

		Curso curso7 = new Curso(7, "Taller de habilidades gerenciales ll", "THGII", 2, curso4, false);

		Curso curso8 = new Curso(8, "Gestión pública", "GP", 3, curso1, false);

		Curso curso9 = new Curso(9, "Gestión social", "GS", 3, false);

		Curso curso10 = new Curso(10, "Gestión de proyectos", "GP", 3, false);

		Curso curso11 = new Curso(11, "Gestión estrategica", "GE", 4, curso8, false);

		Curso curso12 = new Curso(12, "Taller de Habilidades Gerenciales III", "THGIII", 2, curso7, false);

		Curso curso13 = new Curso(13, "Plan de Negocios", "PN", 4, curso11, false);

		Curso curso14 = new Curso(14, "Seminario de Investigacion", "SI", 3, curso5, false);

		Curso curso15 = new Curso(15, "Etica para la Gestion", "EPG", 2, true);

		Curso curso16 = new Curso(16, "Seminario de Investigacion II", "SI2", 4, curso15, true);
		
		Curso curso17 = new Curso(17, "Desarrollo y Responsabilidad Social", "DRS", 3, curso16, true);

		totalCursos.add(curso1);

		totalCursos.add(curso2);

		totalCursos.add(curso3);

		totalCursos.add(curso4);

		totalCursos.add(curso5);

		totalCursos.add(curso6);

		totalCursos.add(curso7);

		totalCursos.add(curso8);

		totalCursos.add(curso9);

		totalCursos.add(curso10);

		totalCursos.add(curso11);

		totalCursos.add(curso12);

		totalCursos.add(curso13);

		totalCursos.add(curso14);

		totalCursos.add(curso15);

		totalCursos.add(curso16);

		totalCursos.add(curso17);

		return totalCursos;

	}
}
