package cr.ac.ucr.planDeEstudios.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.planDeEstudios.datos.PlanEstudiosDatos;
import cr.ac.ucr.planDeEstudios.dominio.Curso;
import cr.ac.ucr.planDeEstudios.dominio.PlanEstudios;

@Service
public class PlanEstudiosNegocios {

	@Autowired
	private PlanEstudiosDatos  planEstudiosDatos;
	

	public List<PlanEstudios> listarPlanEstudios() {
		return planEstudiosDatos.listarPlanEstudios();
	}
	
	public void asignarCurso(Curso curso, PlanEstudios plan) {
		planEstudiosDatos.asignarCurso(curso, plan);
	}
	
}
