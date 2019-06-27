package com.cr.ac.cr.examen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cr.ac.ucr.examen.business.CarreraBusiness;
import com.cr.ac.ucr.examen.business.PlanDeEstudiosBusiness;
import com.cr.ac.ucr.examen.domain.Curso;
import com.cr.ac.ucr.examen.domain.PlanDeEstudio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllTests {
	
	@Autowired
	CarreraBusiness carreraBusiness;
	@Autowired
	PlanDeEstudiosBusiness planBusiness;
	
	//Test 1
	@Test
	public void crearUnCurso() {
		boolean result = false;
		Curso curso = new Curso(20, "PruebaAgregar", "IF0001", 4, "Inicial", "II");
		planBusiness.agregarCurso(1, curso);
		PlanDeEstudio planDeEstudio = carreraBusiness.obtenerPlan(1);
		for (Curso cursoGuardado : planDeEstudio.getCursos()) {
			if(cursoGuardado.getId() == 20) {
				result = true;
			}
		}
		assertTrue(result);
	}
	
	//Test 2
	@Test
	public void crearUnCursoConRequisitos() {
		boolean result = false;
		Curso curso = new Curso(30, "PruebaAgregarRequisito", "IF0001", 4, "Inicial", "I");
		//Se escoge el 8 para que sea un curso intermedio
		Curso cursoConRequisito = planBusiness.obtenerCursos(1).get(8);
		cursoConRequisito.agregarRequisito(curso);
		//Falta actualizar el plan de estudios
		for (Curso requisito : cursoConRequisito.getRequisitos()) {
			if(requisito.getId() == 30);
		}
		assertTrue(result);
	}
	
	//Test 3
	// -------
	
	//Test 4
	//Debe saltar una exepcion
	@Test
	public void cursoFinal() {
		boolean result = false;
		Curso curso = new Curso(40, "PruebaRequisito", "IF0001", 4, "Inicial", "I");
		//Se escoge el 17 para que sea un curso Final
		Curso cursoConRequisito = planBusiness.obtenerCursos(1).get(17);
		cursoConRequisito.agregarRequisito(curso);
	}
	
	//Test 5
	@Test
	public void totalCreditos() {
		int cantidadCreditos = carreraBusiness.obtenerPlan(1).obtenerCantidadTotalDeCreditos();
		assertTrue(cantidadCreditos == 58);
	}
	
	//Test 6
	@Test
	public void obtenerTotalCursos() {
		assertTrue(carreraBusiness.obtenerPlan(1).getCursos().size() == 19);
	}
	
	//Test 7 
	public void obtenerRequisitos() {
		ArrayList<Curso> req = carreraBusiness.obtenerPlan(1).getCursos().get(13).getRequisitos();
		assertTrue(req != null && !req.isEmpty());
	}
}
