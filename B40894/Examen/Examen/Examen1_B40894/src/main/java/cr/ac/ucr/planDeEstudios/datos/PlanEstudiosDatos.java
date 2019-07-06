package cr.ac.ucr.planDeEstudios.datos;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import cr.ac.ucr.planDeEstudios.dominio.Curso;
import cr.ac.ucr.planDeEstudios.dominio.PlanEstudios;


@Repository
public class PlanEstudiosDatos {
	
	
	private List<PlanEstudios> planEstudios = new ArrayList<PlanEstudios>();
	

	public List<PlanEstudios> listarPlanEstudios() {
		
		CursoDatos cursoDatos = new CursoDatos();
		int totalCreditos = 0;
		
	   for (int contador = 0; contador < cursoDatos.listarCursos().size(); contador++) {
		totalCreditos=totalCreditos+cursoDatos.listarCursos().get(contador).getCreditos();
	}
		
		
		PlanEstudios plan1 = new PlanEstudios("InformaticaEmpresarial", cursoDatos.listarCursos(), totalCreditos);
		
		
		planEstudios.add(plan1);
		
		
		return planEstudios;
	}

	
	public void asignarCurso(Curso curso, PlanEstudios plan) {
		List<Curso> cursoLista = new ArrayList<Curso>();
		cursoLista=plan.getCursos();
		cursoLista.add(curso);
		int totalCreditos = plan.getTotalCreditos();
		totalCreditos=totalCreditos+curso.getCreditos();
		plan.setTotalCreditos(totalCreditos);
	}
	
}
