package cr.ac.ucr.planDeEstudios;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import cr.ac.ucr.planDeEstudios.dominio.Curso;
import cr.ac.ucr.planDeEstudios.dominio.Requisito;
import cr.ac.ucr.planDeEstudios.negocios.CursoNegocios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoTest {

	@Autowired
	CursoNegocios cursoNegocios;
	
	@Test
	public void ingresarCurso() {
		
		try
		{
			Curso curso = new Curso("Tecnicas Informaticas", "TI", 2, false);
			cursoNegocios.guardar(curso);
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
		
	}
	
	@Test
	public void ingresarCursoRequisito() {
		
		try
		{
			Requisito requisito = new Requisito("Tecnicas Informaticas", "TI", 2);
			Curso curso = new Curso();
			curso.setRequisito(requisito);
			curso.setCreditos(2);
			curso.setNombre("Tecnico");
			curso.setSiglas("T");
			curso.setIniciaFinal(false);
			cursoNegocios.guardar(curso);
			assertTrue( true);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  false);
		}
		
	}

	@Test
	public void ingresarCursoRequisitoConMismoNombre() {
		
		try
		{
			Requisito requisito = new Requisito("Tecnicas Informaticas", "TI", 2);
			Curso curso = new Curso();
			curso.setRequisito(requisito);
			curso.setCreditos(2);
			curso.setNombre("Tecnicas Informaticas");
			curso.setSiglas("T");
			curso.setIniciaFinal(false);
			cursoNegocios.guardar(curso);
			assertTrue( false);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  true);
		}
		
	}
	
	@Test
	public void cursoFinalSiendoRequisito() {
		
		try
		{
			
			
			Curso curso2 = new Curso();
			curso2.setCreditos(2);
			curso2.setNombre("Lenguajes");
			curso2.setSiglas("T");
			curso2.setIniciaFinal(true);
			
			Requisito requisito = new Requisito(curso2.getNombre(), curso2.getSiglas(), curso2.getCreditos());
			
			Curso curso = new Curso();
			curso.setRequisito(requisito);
			curso.setCreditos(2);
			curso.setNombre("Tecnicas Informaticas");
			curso.setSiglas("T");
			curso.setIniciaFinal(false);
			
			cursoNegocios.guardar(curso);
			
			assertTrue( true);
		}
		catch (RuntimeException e) 
		{
			assertTrue(  false);
		}
		
	}
}
