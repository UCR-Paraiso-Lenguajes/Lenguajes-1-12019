package ucr.ac.cr.planDeEstudios.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.planDeEstudios.data.PlanData;
import ucr.ac.cr.planDeEstudios.domain.Curso;
import ucr.ac.cr.planDeEstudios.domain.Plan;

@Service
public class PlanBusiness {
	@Autowired
	private PlanData planData;
	
	public Curso traeCursoPlan(String nombreCurso) {
		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		return planData.traeCursoPlan(nombreCurso);
	}
	public ArrayList<Curso> traeCursos(){
		/*CUANDO LA APLICACIÓN RECUPERE ESTADO CREÉ ESTE PLAN DE ESTUDIOS COMPLETO EN MEMORIA */

		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		return planData.listarCursos();
	}
	public void insertarCurso(String nombreArea, String nombreCiclo, Curso curso) {
		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		planData.insertarCurso(nombreArea, nombreCiclo, curso);
	}
	public void eliminaCurso(String nombreCurso) {
		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		planData.eliminaCurso(nombreCurso);
	}
	public void actualizaCurso(String nombreCurso, Curso curso) {
		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		planData.actualiza(nombreCurso, curso);
	}
}
