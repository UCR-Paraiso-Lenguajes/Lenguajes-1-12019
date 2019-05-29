package ucr.ac.cr.B76223.examen1.business;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.B76223.examen1.domain.Curso;
import ucr.ac.cr.B76223.examen1.domain.Plan;

@Service
public class PlanBusiness {

	List<Plan> planes = new LinkedList<>();
	Plan planActual = new Plan();

	public Plan recuperarEstado() {

		return planEstado();
	}

	public Plan planEstado() {

		Curso curso1 = new Curso("Teoria Organizacional", "TO-3", 3);
		Curso curso2 = new Curso("Metodo de Investigacion Cualitativo", "MCI-4", 4);
		Curso curso3 = new Curso("Metodo de Investigacion Cualitativo", "MCI-3", 3);
		Curso curso4 = new Curso("Economia aplicada a la gestion", "EAG-4", 4);
		Curso curso5 = new Curso("Taller de Habilidades Gerenciales", "THGI-2", 2);
		Curso curso6 = new Curso("Bases Legales de la Gestion", "BLG-5", 5);
		Curso curso7 = new Curso("Economia aplicada a la gestion II", "EAG-4", 4);
		Curso curso8 = new Curso("Taller de Habilidades Gerenciales II", "THGII-2", 2);
		Curso curso9 = new Curso("Gestion publica", "GP-3", 3);
		Curso curso10 = new Curso("Gestion Social", "GS-3", 3);
		Curso curso11 = new Curso("Gestion de proyectos", "GT-4", 4);
		Curso curso12 = new Curso("Gestion Estrategica", "GE-4", 4);
		Curso curso13 = new Curso("Plan de negocios", "PLN-4", 4);
		Curso curso14 = new Curso("Taller de Habilidades Gerenciales", "THGIII-2", 2);
		Curso curso15 = new Curso("Seminario de Investigacion", "SI-3", 3);
		Curso curso16 = new Curso("Etica para la Gestion", "EG-2", 2);
		Curso curso17 = new Curso("Seminario de Investigacion II", "SI-3", 3);
		Curso curso18 = new Curso("Desarrollo y Responsabilidad Social", "DRS-3", 3);

		List<Curso> cursosDisponibles = new LinkedList<Curso>();

		cursosDisponibles.add(curso1);
		cursosDisponibles.add(curso2);
		cursosDisponibles.add(curso3);
		cursosDisponibles.add(curso4);
		cursosDisponibles.add(curso5);
		cursosDisponibles.add(curso6);
		cursosDisponibles.add(curso7);
		cursosDisponibles.add(curso8);
		cursosDisponibles.add(curso9);
		cursosDisponibles.add(curso10);
		cursosDisponibles.add(curso11);
		cursosDisponibles.add(curso12);
		cursosDisponibles.add(curso13);
		cursosDisponibles.add(curso14);
		cursosDisponibles.add(curso15);
		cursosDisponibles.add(curso16);
		cursosDisponibles.add(curso17);
		cursosDisponibles.add(curso18);

		Plan plan = new Plan("Innovacion", 18, cursosDisponibles);

		return plan;
	}

	public Plan insertarPlan(Plan plan) {

		if (plan.getNombre().equals(""))
			throw new RuntimeException("El nombre debe ser válido");
		planes.add(plan);

		return plan;
	}

	public String borrarPlan(String plan) {
		if (plan.equals(""))
			throw new RuntimeException("El nombre debe ser válido");

		for (int i = 0; i < planes.size(); i++) {
			if (planes.get(i).getNombre().equals(plan)) {

				planes.remove(i);
			}

		}
		return plan;
	}

	public Plan actualizarPlan(Plan plan) {
		if (plan.getNombre().equals(""))
			throw new RuntimeException("El nombre debe ser válido");
		planes.add(plan);

		return plan;
	}

	public Plan listarPlan(String nombrePlan) {
		
		Plan plan = new Plan();
		for (int i = 0; i < planes.size(); i++) {
			if (planes.get(i).getNombre().equals(nombrePlan)) {

				plan = planes.get(i);
			}
		}

		return plan;
	}

	public Plan deletePlan(String nombrePlan) {
		if (nombrePlan.equals(""))
			throw new RuntimeException("El nombre debe ser válido");
		Plan plan = new Plan();
		for (int i = 0; i < planes.size(); i++) {
			if (planes.get(i).getNombre().equals(nombrePlan)) {
				plan = planes.get(i);
			}
		}

		return plan;
	}
}
