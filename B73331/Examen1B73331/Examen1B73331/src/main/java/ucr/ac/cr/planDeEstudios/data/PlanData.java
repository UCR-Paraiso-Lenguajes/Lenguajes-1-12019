package ucr.ac.cr.planDeEstudios.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ucr.ac.cr.planDeEstudios.domain.Plan;
import ucr.ac.cr.planDeEstudios.domain.Area;
import ucr.ac.cr.planDeEstudios.domain.Ciclo;
import ucr.ac.cr.planDeEstudios.domain.Curso;

@Repository
public class PlanData {
	private Plan plan;

	public void inicializarPlan(Plan plan) {
		this.plan = plan;
	}

	public Plan recuperarEstado() {

		// plan = new Plan("Carrera de Innovacion");
		// int idCiclo, int id, String nombre CURSO
		// int idArea, int idCiclo, String nombre, List<Curso> cursos CLICLO
		// (String nombre, int id, List<Ciclo> ciclos) AREA
		/************ AREA 1 *********/

		// ciclos = new ArrayList<>();
		// cursos = new ArrayList<>();
		// String nombreArea, String nombreCiclo, Curso cursoAInsertar
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo V", new Curso(0, 0, "Teoria Organizacional", 3, "TO"));
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo VII", new Curso(2, 2, "Gestion Publica", 3, "GP"));
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo VII", new Curso(2, 3, "Gestion Social", 3, "GS"));
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo VII", new Curso(2, 4, "Gestion Proyectos", 4, "GPR"));
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo VIII", new Curso(3, 5, "Gestion Estrategica", 4, "GE"));
		insertarCurso("ESTRATEGIA E INNOVACION", "Ciclo IX", new Curso(4, 6, "Plan Negocios", 4, "PLN"));

		/************ AREA 2 *********/
		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo V",
				new Curso(0, 7, "Metodos de Investigacion Cualitativa", 4, "MIC"));
		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo V",
				new Curso(0, 8, "Metodos de Investigacion Cualitativa II", 3, "MICII"));
		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo V",
				new Curso(0, 9, "Economia aplicada a la Gestion", 4, "EAG"));

		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo VI",
				new Curso(1, 10, "Bases Legales para la Gestion", 5, "BLG"));
		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo VI",
				new Curso(1, 11, "Economia aplicada a la Gestion II", 4, "EAGII"));

		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo IX", new Curso(4, 12, "Seminario de Investigacion", 3, "SI"));

		insertarCurso("ANALISIS E INVESTIGACION", "Ciclo X",
				new Curso(5, 13, "Seminario de Investigacion II", 4, "SIII"));

		/************ AREA 3 *********/
		insertarCurso("HABILIDADES GERENCIALES", "Ciclo V",
				new Curso(0, 14, "Taller de Habilidades Gerenciales", 2, "THG"));

		insertarCurso("HABILIDADES GERENCIALES", "Ciclo VI",
				new Curso(1, 15, "Taller de Habilidades Gerenciales II", 2, "THGII"));

		insertarCurso("HABILIDADES GERENCIALES", "Ciclo VIII",
				new Curso(3, 16, "Taller de Habilidades Gerenciales III", 2, "THGIII"));

		/************ AREA 4 *********/
		insertarCurso("ETICA Y SOSTENIBILIDAD", "Ciclo IX", new Curso(4, 17, "Etica para la Gestion", 2, "EGE"));

		insertarCurso("ETICA Y SOSTENIBILIDAD", "Ciclo X",
				new Curso(5, 18, "Desarrollo y Responsabilidad social", 3, "DRS"));

		/************ Fin Areas *********/

		return plan;
	}

	private Curso traeCurso(ArrayList<Curso> listaCursos, String nombreCurso, ArrayList<Curso> listaAppend) {
		if (listaCursos.size() == 0) {
			return null;
		}
		Curso curso = new Curso();
		int size = listaCursos.size();
		for (int i = 0; i < size; i++) {
			curso = listaCursos.get(i);
			listaAppend.add(curso);
			if (curso.getNombre().equals(nombreCurso)) {
				return curso;
			}
		}
		return null;
	}

	private boolean eliminaCurso(ArrayList<Curso> listaCursos, String nombreCurso) {
		if (listaCursos.size() == 0) {
			
		} else {
			Curso curso = new Curso();
			int size = listaCursos.size();
			for (int i = 0; i < size; i++) {
				curso = listaCursos.get(i);
				if (curso.getNombre().equals(nombreCurso)) {
					listaCursos.remove(i);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	private boolean eliminaCursoCiclo(ArrayList<Ciclo> listaCiclos, String nombreCurso) {
		Curso curso = new Curso();
		boolean borrado = false;
		int size = listaCiclos.size();
		for (int i = 0; i < size; i++) {
			if (listaCiclos.get(i).getCursos().size() != 0) {
				borrado = eliminaCurso(listaCiclos.get(i).getCursos(), nombreCurso);
				if(borrado) {
					return borrado;
				}
			}

		}
		return borrado;
	}
	private boolean eliminaCursoArea(ArrayList<Area> listaAreas, String nombreCurso) {
		
		Curso curso = new Curso();
		boolean iteracion = false;
		int size = listaAreas.size();
		for (int i = 0; i < size; i++) {
			if (listaAreas.get(i).getCiclos().size() != 0) {
				iteracion = eliminaCursoCiclo(listaAreas.get(i).getCiclos(), nombreCurso);
				if(iteracion) {
					return iteracion;
				}
			}

		}
		return iteracion;
	}
	private boolean editaCurso(ArrayList<Curso> listaCursos, String nombreCurso, Curso cursoActualizado) {
		if (listaCursos.size() == 0) {
			
		} else {
			Curso curso = new Curso();
			int size = listaCursos.size();
			for (int i = 0; i < size; i++) {
				curso = listaCursos.get(i);
				if (curso.getNombre().equals(nombreCurso)) {
					listaCursos.remove(i);
					listaCursos.add(cursoActualizado);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	private boolean editaCursoCiclo(ArrayList<Ciclo> listaCiclos, String nombreCurso, Curso cursoActualizado) {
		Curso curso = new Curso();
		boolean borrado = false;
		int size = listaCiclos.size();
		for (int i = 0; i < size; i++) {
			if (listaCiclos.get(i).getCursos().size() != 0) {
				borrado = editaCurso(listaCiclos.get(i).getCursos(), nombreCurso,cursoActualizado);
				if(borrado) {
					return borrado;
				}

			}

		}
		return borrado;
	}
private boolean editaCursoArea(ArrayList<Area> listaAreas, String nombreCurso, Curso cursoActualizado) {
		
		Curso curso = new Curso();
		boolean iteracion = false;
		int size = listaAreas.size();
		for (int i = 0; i < size; i++) {
			if (listaAreas.get(i).getCiclos().size() != 0) {
				iteracion = editaCursoCiclo(listaAreas.get(i).getCiclos(), nombreCurso,cursoActualizado);
				if(iteracion) {
					return iteracion;
				}
			}

		}
		return iteracion;
	}
	private Curso traeCursoCiclo(ArrayList<Ciclo> listaCiclos, String nombreCurso, ArrayList<Curso> listaAppend) {
		Curso curso = new Curso();
		int size = listaCiclos.size();
		for (int i = 0; i < size; i++) {
			if (listaCiclos.get(i).getCursos().size() != 0) {
				curso = traeCurso(listaCiclos.get(i).getCursos(), nombreCurso, listaAppend);

				if (curso != null) {

					if (curso.getNombre().equals(nombreCurso)) {
						return curso;
					}
				}
			}

		}
		return null;
	}

	private Curso traeCursoArea(ArrayList<Area> listaAreas, String nombreCurso) {
		ArrayList<Curso> listaAppend = new ArrayList<Curso>();
		Curso curso = new Curso();
		int size = listaAreas.size();
		for (int i = 0; i < size; i++) {
			if (listaAreas.get(i).getCiclos().size() != 0) {
				curso = traeCursoCiclo(listaAreas.get(i).getCiclos(), nombreCurso, listaAppend);
				if (curso != null) {
					if (curso.getNombre().equals(nombreCurso)) {
						return curso;
					}
				}
				listaAppend = new ArrayList<Curso>();
			}

		}
		return null;
	}

	private ArrayList<Curso> traeCursoAreaLista(ArrayList<Area> listaAreas, String nombreCurso) {
		ArrayList<Curso> listaAppend = new ArrayList<Curso>();
		ArrayList<Curso> listaAppend2 = new ArrayList<Curso>();
		Curso curso = new Curso();
		int size = listaAreas.size();
		for (int i = 0; i < size; i++) {
			if (listaAreas.get(i).getCiclos().size() != 0) {
				curso = traeCursoCiclo(listaAreas.get(i).getCiclos(), nombreCurso, listaAppend);
				if (curso != null) {
					if (curso.getNombre().equals(nombreCurso)) {
						int listSize = listaAppend.size();
						listaAppend2 = listaAppend;
					}
				}
				listaAppend = new ArrayList<Curso>();
			}

		}

		size = listaAppend2.size();
		ArrayList<Curso> listaAppend3 = new ArrayList<Curso>();
		Curso cursoEncontrado = traeCursoPlan(nombreCurso);
		for (int i = 0; i < size; i++) {
			if (listaAppend2.get(i).getIdCiclo() != cursoEncontrado.getIdCiclo()) {
				listaAppend3.add(listaAppend2.get(i));
			}
		}

		return listaAppend3;
	}

	private void traeTodosCursos(ArrayList<Curso> listaCursos, ArrayList<Curso> listaAppend) {
		int size = listaCursos.size();
		for (int i = 0; i < size; i++) {
			listaAppend.add(listaCursos.get(i));
		}
	}

	private void traeTodosCursosCiclo(ArrayList<Ciclo> listaCiclos, ArrayList<Curso> listaAppend) {
		int size = listaCiclos.size();
		for (int i = 0; i < size; i++) {
			if (listaCiclos.get(i).getCursos().size() != 0) {
				traeTodosCursos(listaCiclos.get(i).getCursos(), listaAppend);
			}

		}
	}

	private ArrayList<Curso> traeTodosCursosArea(ArrayList<Area> listaAreas) {
		ArrayList<Curso> listaAppend = new ArrayList<Curso>();
		int size = listaAreas.size();
		for (int i = 0; i < size; i++) {
			if (listaAreas.get(i).getCiclos().size() != 0) {
				traeTodosCursosCiclo(listaAreas.get(i).getCiclos(), listaAppend);
			}

		}
		return listaAppend;
	}

	private void insertarEnCiclo(ArrayList<Ciclo> listaCiclos, String nombreCiclo, Curso cursoAInsertar) {
		int size = listaCiclos.size();

		for (int i = 0; i < size; i++) {
			if (listaCiclos.get(i).getNombre().equals(nombreCiclo)) {
				// Buque en cursos
				listaCiclos.get(i).getCursos().add(cursoAInsertar);
			}
		}
	}

	private void insertaEnAreaEspecifico(String nombreArea, String nombreCiclo, Curso cursoAInsertar) {
		int size = plan.getAreas().size();

		for (int i = 0; i < size; i++) {
			if (plan.getAreas().get(i).getNombre().equals(nombreArea)) {
				// Busque en el ciclo
				insertarEnCiclo(plan.getAreas().get(i).getCiclos(), nombreCiclo, cursoAInsertar);
			}
		}
	}
/*-------------------------CRUD-----------------------------------*/
	public ArrayList<Curso> listarCursos() {
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		listaCursos = traeTodosCursosArea(plan.getAreas());
		return listaCursos;
	}
	public void insertarCurso(String nombreArea, String nombreCiclo, Curso cursoAInsertar) {
		insertaEnAreaEspecifico(nombreArea, nombreCiclo, cursoAInsertar);
	}
	public boolean eliminaCurso(String nombreCurso) {
		
		return eliminaCursoArea(plan.getAreas(),nombreCurso);
		
	}
	public boolean actualiza(String nombreCurso, Curso cursoAInsertar) {
		return editaCursoArea(plan.getAreas(), nombreCurso, cursoAInsertar);
	}
	/*-------------------------CRUD-----------------------------------*/
	public Curso traeCursoPlan(String nombreCurso) {
		Curso curso = new Curso();
		curso = traeCursoArea(plan.getAreas(), nombreCurso);

		return curso;
	}

	public ArrayList<Curso> traeCursosRequisito(String nombreCurso) {
		return traeCursoAreaLista(plan.getAreas(), nombreCurso);
	}

	

	public int traerCantidadCreditos() {
		ArrayList<Curso> totalCursos = listarCursos();
		int size = totalCursos.size();
		int sumatoria = 0;
		for (int i = 0; i < size; i++) {
			sumatoria += totalCursos.get(i).getCreditos();
		}
		return sumatoria;
	}

	public int traeCantidadDeCursos() {
		return listarCursos().size();
	}
}
