package com.examen.b24075.data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.b24075.domain.Curso;
import com.examen.b24075.domain.Plan;


@SpringBootTest
public class CursoDataTest {
	
	@Autowired
	
	CursoData cd;

	
	//CREACIÓN DE UN CURSO Y ASIGNARLO A UN PLAN. 5PTS
	@Test
	public void guardar() {
		
		Plan p = new Plan("turismo");
		
		Curso c = new Curso("curso para alimentos","AL78",3,new ArrayList<Curso>(),p);
		
	
		assertNotNull(cd.guardarCurso(c));
		
	}
	
	//2. CREACIÓN DE UN CURSO CON REQUISITOS. 5PTS
	
	@Test
	public void guardarConRequisitos() {
		
		Plan p = new Plan("ense;anza del ingles");
		
		ArrayList<Curso> requisitos = new ArrayList<Curso>();
		
		requisitos.add(new Curso("lectura2","ALf78",3,new ArrayList<Curso>(),p));
		
		Curso c = new Curso("lectura3","AL7r8",3,requisitos,p);
		
	
		assertNotNull(cd.guardarCurso(c));
		
	}
	
	
	///test para crud
	
	@Test
	public void eliminarCursoyBuscar() {
		
		Plan p = new Plan("turismo");
		
		Curso c = new Curso("curso para alimentos","AL78",3,new ArrayList<Curso>(),p);
		cd.eliminarCurso(c);
		
		assertFalse(cd.existeCurso(c));
		
		
	}
	
	@Test
	public void actualizaryBuscarCurso() {
		
		Plan p = new Plan("turismo");
		
		Curso c = new Curso("curso para alimentos","AL78",3,new ArrayList<Curso>(),p);
		cd.guardarCurso(c);
		
		c.setNombre("alimentos");
		cd.actualizarCurso(c);
		assertNotNull(cd.buscarCurso(c));

		
		
	}
	
	
	@Test
	public void obtenerRequisitosCurso() {
		
Plan p = new Plan("ense;anza del ingles");
		
		ArrayList<Curso> requisitos = new ArrayList<Curso>();
		
		requisitos.add(new Curso("lectura2","ALf78",3,new ArrayList<Curso>(),p));
		
		Curso c = new Curso("lectura3","AL7r8",3,requisitos,p);
		
	
		assertNotNull(cd.obtenerRequisitosCurso(c));
		
	}
	
}
