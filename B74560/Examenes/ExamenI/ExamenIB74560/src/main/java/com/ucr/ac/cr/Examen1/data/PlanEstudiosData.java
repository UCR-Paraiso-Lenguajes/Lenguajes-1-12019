package com.ucr.ac.cr.Examen1.data;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucr.ac.cr.Examen1.domain.Area;
import com.ucr.ac.cr.Examen1.domain.Curso;
import com.ucr.ac.cr.Examen1.domain.PlandeEstudios;
import com.ucr.ac.cr.Examen1.exception.ExamenException;

public class PlanEstudiosData {

	public int credictosTotales = 0;
	public int cursosTotales = 0;
	@Autowired
	public PlandeEstudios plan;

	@Autowired
	private Curso cursoEncontrado;


	public ArrayList<Curso> ListaCursos = new ArrayList<Curso>();

	public void llenarLista() {

		/* Primer Ciclo */

		Curso organizacional = new Curso("Teoria Organizacional", Area.Estrategia.getNombreArea(), "TO-1E", 3, 1);
		ListaCursos.add(organizacional);

		Curso investigacionCualitativa = new Curso("Metodos de Investigacion Cualitativa",
				Area.Analisis.getNombreArea(), "MICl-1A", 4, 1);

		Curso investigacionCuantitativa = new Curso("Metodos de Investigacion Cuantitativa",
				Area.Analisis.getNombreArea(), "MICn-1A", 3, 1);
		Curso economia = new Curso("Economia Aplicada a la Gestion", Area.Analisis.getNombreArea(), "EAG-1A", 4, 1);

		ListaCursos.add(investigacionCualitativa);
		ListaCursos.add(investigacionCuantitativa);
		ListaCursos.add(economia);

		Curso tallerGerencial = new Curso("Taller de Habilidades Gerenciales", Area.Habilidades.getNombreArea(),
				"THG-1H", 2, 1);
		ListaCursos.add(tallerGerencial);

		/* Segundo Ciclo */

		Curso basesLegales = new Curso("Bases Legales para la Gestion", Area.Analisis.getNombreArea(), "BLG-2A", 5, 2);
		Curso economiaDos = new Curso("Economia Aplicada a la Gestion II", Area.Analisis.getNombreArea(), "EAGII-2A", 4,
				2);
		ListaCursos.add(basesLegales);
		ListaCursos.add(economiaDos);

		Curso tallerGerencialDos = new Curso("Taller de Habilidades Gerenciales II", Area.Habilidades.getNombreArea(),
				"THG-2T", 2, 2);
		ListaCursos.add(tallerGerencialDos);

		/* Tercer ciclo */
		Curso gestionPublica = new Curso("Gestion Publica", Area.Estrategia.getNombreArea(), "GP-3E", 3, 3);
		Curso gestionSocial = new Curso("Gestion Social", Area.Estrategia.getNombreArea(), "GS-3E", 3, 3);
		Curso gestionProyecto = new Curso("Gestion de Proyectos", Area.Estrategia.getNombreArea(), "GPj-3E", 4, 3);

		ListaCursos.add(gestionPublica);
		ListaCursos.add(gestionSocial);
		ListaCursos.add(gestionProyecto);

		/* Cuarto ciclo */

		Curso gestionEstrategica = new Curso("Gestion Estrategica", Area.Estrategia.getNombreArea(), "GE-4E", 4, 4);
		ListaCursos.add(gestionEstrategica);

		Curso tallerGerencialTres = new Curso("Taller de Habilidades Gerenciales III", Area.Habilidades.getNombreArea(),
				"THG-4A", 2, 4);
		ListaCursos.add(tallerGerencialTres);

		/* Quinto ciclo */

		Curso planNegocio = new Curso("Plan de Negocios", Area.Estrategia.getNombreArea(), "PN-5A", 4, 5);
		ListaCursos.add(planNegocio);

		Curso seminario = new Curso("Seminario de Investigacion", Area.Analisis.getNombreArea(), "SI-5A", 3, 5);

		ListaCursos.add(seminario);

		Curso eticaCurso = new Curso("Etica para la Gestion", Area.Etica.getNombreArea(), "EG-5Et", 2, 5);

		ListaCursos.add(eticaCurso);

		/* Sexto Ciclo */

		Curso seminarioDos = new Curso("Seminario de Investigacion II", Area.Analisis.getNombreArea(), "SIII-6A", 4, 6);

		ListaCursos.add(seminarioDos);

		Curso desarrollo = new Curso("Desarrollo Social y Responsabilidad Social", Area.Etica.getNombreArea(),
				"DSRS-6Et", 3, 6);

		ListaCursos.add(desarrollo);

		for (int i = 0; i < ListaCursos.size(); i++) {
			credictosTotales += ListaCursos.get(i).getCredictos();
		}

		cursosTotales = ListaCursos.size();

		plan = new PlandeEstudios(ListaCursos);
	}

	public void insertarCurso(Curso curso) {

		ListaCursos.add(curso);
		credictosTotales += curso.getCredictos();
		cursosTotales++;
		plan = new PlandeEstudios(ListaCursos);

	}

	public ArrayList<Curso> insertarCursoRequisitos(Curso curso) {
		ArrayList<Curso> returnLista = new ArrayList<Curso>();
		insertarCurso(curso);

		returnLista = buscarRequesitos(curso);

		return returnLista;
	}

	private ArrayList<Curso> buscarRequesitos(Curso curso) {

		ArrayList<Curso> returnLista = new ArrayList<Curso>();

		if (curso.getArea().contentEquals("Analisis")) {
			for (int i = 0; i < ListaCursos.size(); i++) {
				if (ListaCursos.get(i).getArea().contentEquals("Analisis") && ListaCursos.get(i).getCiclo() < curso.getCiclo()) {
					returnLista.add(ListaCursos.get(i));
				}
			}
		} else if (curso.getArea().contentEquals("Estrategia")) {
			for (int i = 0; i < ListaCursos.size(); i++) {
				if (ListaCursos.get(i).getArea().contentEquals("Estrategia")
						&& ListaCursos.get(i).getCiclo() < curso.getCiclo()) {
					returnLista.add(ListaCursos.get(i));
				}
			}
		} else if (curso.getArea().contentEquals("Etica")) {
			for (int i = 0; i < ListaCursos.size(); i++) {
				if (ListaCursos.get(i).getArea().contentEquals("Etica") && ListaCursos.get(i).getCiclo() < curso.getCiclo()) {
					returnLista.add(ListaCursos.get(i));
				}
			}
		} else if (curso.getArea().contentEquals("Habilidades")) {
			for (int i = 0; i < ListaCursos.size(); i++) {
				if (ListaCursos.get(i).getArea().contentEquals("Habilidades")
						&& ListaCursos.get(i).getCiclo() < curso.getCiclo()) {
					returnLista.add(ListaCursos.get(i));
				}
			}
		}

		return returnLista;

	}

	public boolean existe(Curso curso) {

		for (int i = 0; i < ListaCursos.size(); i++) {
			if (ListaCursos.get(i).getSiglaCurso().contentEquals(curso.getSiglaCurso())) {
				cursoEncontrado = ListaCursos.get(i);
				return true;
			}
		}
		return false;

	}
	
	public ArrayList<Curso> buscarRequisitosExistente(Curso curso){
		
		if (existe(curso)) {
			return buscarRequesitos(cursoEncontrado);
		}else {
				throw new ExamenException("No existe curso");
		}
		
	}
	
	
}
