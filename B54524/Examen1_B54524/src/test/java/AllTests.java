import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cr.ac.ucr.examen.business.PlanDeEstudiosBusiness;
import com.cr.ac.ucr.examen.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllTests {
	
	@Autowired
	PlanDeEstudiosBusiness estudiosBusiness;
	
	//Test 1
	@Test
	public void crearUnCurso() {
		Curso curso = new Curso("PruebaAgregar", "IF0001", 4, "Inicial");
		estudiosBusiness.agregarCurso("Informatica", curso);
		ArrayList<Curso> cursos = estudiosBusiness.obtenerPlan("Informatica"); 
		for (Curso curso2 : cursos) {
			assertTrue(curso2.getSigla().equals(curso.getSigla()));
		}
	}
	
	//Test 2
	@Test
	public void crearUnCursoConRequisitos() {
		Curso curso = new Curso("PruebaAgregarRequisito", "IF0001", 4, "Inicial");
		ArrayList<Curso> cursos = estudiosBusiness.obtenerPlan("Informatica");
		Curso cursoConRequisito = cursos.get(1);
		cursoConRequisito.agregarRequisito(curso);
		for (Curso requisitos : cursoConRequisito.getRequisitos()) {
			assertTrue(requisitos.getSigla().equals(curso.getSigla()));
		}
	}
	
	//Test 3
	// -------
	
	
}
