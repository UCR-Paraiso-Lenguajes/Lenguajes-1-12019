package ucr.ac.cr.planDeEstudios.data;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ucr.ac.cr.planDeEstudios.domain.Curso;
import ucr.ac.cr.planDeEstudios.domain.Plan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanDataTest {

	@Autowired
	private PlanData planData;
	
	@Test
	public void recuperarEstadoTest() {
		
		Plan plan = new Plan("Carrera de Innovacion");
		planData.inicializarPlan(plan);
		planData.recuperarEstado();
		
		assertNotNull(plan);
		
	}
	@Test
	public void traeCursoPlanTest() {
		Curso curso = planData.traeCursoPlan("Gestion Proyectos");
		
		assertNotNull(curso);
		
	}
	@Test
	public void traeCursosRequisitoTest() {
		/*7.EL PLAN DE ESTUDIOS PUEDEN CALCULAR LOS CURSOS REQUERIDOS PARA UNO ESPECÍFICO. */
		ArrayList<Curso>cursosRequeridos = planData.traeCursosRequisito("Gestion Proyectos");
		
		assertNotNull(cursosRequeridos);
		cursosRequeridos = planData.traeCursosRequisito("Metodos de Investigacion Cualitativa II");
		assertNotNull(cursosRequeridos);
		cursosRequeridos = planData.traeCursosRequisito("Seminario de Investigacion II");
		assertNotNull(cursosRequeridos);
	}
	@Test
	public void listarCursos() {
		ArrayList<Curso>totalCursos = planData.listarCursos();
		assertNotNull(totalCursos);
	}
	//@Test ///1.CREACIÓN DE UN CURSO Y ASIGNARLO A UN PLAN.     
	@Test
	public void insertarCursoSinRequisitos() {
		
		planData.insertarCurso("ETICA Y SOSTENIBILIDAD","Ciclo V",
				new Curso(0, 25, "CURSO NUEVO 1", 2, "CN1"));
		
	}
	@Test //2.CREACIÓNDEUNCURSOCONREQUISITOS.  
	public void insertarCursoConRequisito() {
		//TIENE REQUISITOS POR QUE TIENE CURSOS DETRAS DE EL, MIS OBJETOS NO TIENEN UN ATRIBUTO REQUISITOS
		//LOS REQUISITOS SE BASAN EN SI TIENEN CURSOS DETRAS DE ELLOS EN EL AREA CORRESPONDIENTE
		planData.insertarCurso("ANALISIS E INVESTIGACION","Ciclo VII",
				new Curso(2, 26, "CURSO NUEVO 2", 4, "CN2"));
		
		ArrayList<Curso>totalCursos = planData.listarCursos();
		assertNotNull(totalCursos);
	}
	@Test //EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CRÉDITOS CORRECTA EN FUNCIÓN DE LOS CURSOS INSERTADOS.  
	public void traerCantidadCreditosTest() {
		int creditos = planData.traerCantidadCreditos();
		assertNotEquals(0, creditos);
	}
	@Test //EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CURSOS CORRECTA EN FUNCIÓN DE LOS CURSOS INSERTADOS.  
	public void traeCantidadDeCursosTest() {
		int cursos = planData.traeCantidadDeCursos();
		assertNotEquals(0, cursos);
	}
	@Test
	public void eliminaCursoTest() {
		int cursosAntes = planData.traeCantidadDeCursos();
		boolean borrado = planData.eliminaCurso("CURSO NUEVO 2");
		int cursosDespues = planData.traeCantidadDeCursos();
		assertTrue(cursosAntes>cursosDespues);
	}
	@Test
	public void editaCurso() {
		Curso cursoNuevo = new Curso(2, 26, "CURSO NUEVO 3", 4, "CN3");
		boolean editado = planData.actualiza("CURSO NUEVO 1", cursoNuevo);
		ArrayList<Curso>totalCursos = planData.listarCursos();
		assertTrue(editado);
		
	}
}
