package Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Domain.Curso;
import Domain.PlanEstudios;
public class CursoBusiness {
	
//	private List<Curso> cursos = new ArrayList<Curso>();
	@Autowired
	private PlanEstudiosBusiness planBusiness;
	
	public void insertarCurso(Curso curso, PlanEstudios plan) {
		
		if(curso!=null) {
		insertarCursoEnPlan(curso, plan);
		} throw new RuntimeException("El curso que se pretende insertar, no es válido.");
	}
	
	public void insertarCursoEnPlan(Curso curso, PlanEstudios plan) {
		planBusiness.getPlan(plan).getCursosDelPlan().add(curso);
	}
	
	public List<Curso> listarCursosPorPlan(PlanEstudios plan){
		return planBusiness.getPlan(plan).getCursosDelPlan();	
	}
		
	public void eliminarCurso(Curso curso, PlanEstudios plan) {
		List<Curso> cursosPlan = planBusiness.getPlan(plan).getCursosDelPlan();
		for (int i = 0; i < cursosPlan.size(); i++) {
			if(cursosPlan.get(i).getSigla().equals(curso.getSigla())) {
				cursosPlan.remove(curso);
			} throw new RuntimeException("El curso no se encuentra en la lista de cursos.");
		}
	}
	
	public void editarCurso(Curso curso, PlanEstudios plan) {
		
		List<Curso> cursosPlan = planBusiness.getPlan(plan).getCursosDelPlan();
		for (int i = 0; i < cursosPlan.size(); i++) {
			if(cursosPlan.get(i).getSigla().equals(curso.getSigla())) {
				cursosPlan.get(i).setNombre(curso.getNombre());
				cursosPlan.get(i).setCreditos(curso.getCreditos());
				planBusiness.getPlan(plan).setCursosDelPlan(cursosPlan);
			} throw new RuntimeException("El curso no se encuentra en la lista de cursos.");
		}
	}
	

	public void insertarRequisitos(PlanEstudios plan, Curso curso, List<Curso> cursosRequisito) {
		
		List<Curso> cursosPlan = planBusiness.getPlan(plan).getCursosDelPlan();
		for (int i = 0; i < cursosPlan.size(); i++) {
			if(cursosPlan.get(i).getSigla().equals(curso.getSigla())) throw new RuntimeException("El curso no puede ser requisito de sí mismo.");
			if(cursosPlan.get(i).isBloqueFinal()) throw new RuntimeException("El curso no puede ser requisito");
			if(curso.isBloqueInicial()) throw new RuntimeException("El curso no puede tener requisitos.");
			cursosPlan.get(i).getCursosRequisito().add(cursosPlan.get(i));
		}
			
		
	}

}
