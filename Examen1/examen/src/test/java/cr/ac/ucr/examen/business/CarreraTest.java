package cr.ac.ucr.examen.business;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.ac.ucr.examen.domain.Carrera;
import cr.ac.ucr.examen.domain.Ciclo;
import cr.ac.ucr.examen.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarreraTest {


	
	@Test
	public void crearCurso() 
	{
		
		Carrera innovacion = new Carrera();
		
		Curso teoria_o = new Curso("Teoría Organizacional","IF0001",3,1);
		
		Ciclo c = new Ciclo();
		
		innovacion.insertarCursosCarrera(teoria_o, c);
		
		assertEquals(3, innovacion.getTotalCreditos());
		assertEquals(1, innovacion.getTotalCursos());
	}
	
	
	
	@Test
	public void crearCursoConRequisistos() 
	{
		
		Carrera innovacion = new Carrera();
		
		Curso teoria_o = new Curso("Teoría Organizacional","IF0001",3,1);
		Curso ges_pu = new Curso("Gestión Pública","IF0101",3,1);
		Curso ges_soc = new Curso("Gestión Social","IF0102",3,1);
		Curso ges_pro = new Curso("Gestión de Proyectos","IF0103",4,1);
		
		
		Ciclo c1 = new Ciclo();
		Ciclo c2 = new Ciclo();
		Ciclo c3 = new Ciclo();
		
		
		innovacion.insertarCursosCarrera(teoria_o, c1);
		
		innovacion.insertarCursosCarrera(ges_pu, c3);
		innovacion.insertarCursosCarrera(ges_soc, c3);
		innovacion.insertarCursosCarrera(ges_pro, c3);
		
		
		
		
		assertEquals(13, innovacion.getTotalCreditos());
		assertEquals(4, innovacion.getTotalCursos());
	
		
		
		Iterator<Ciclo> it = innovacion.cursosRequisitos(ges_soc);
		while(it.hasNext()) {
			assertEquals(teoria_o, it.next());
		}
		
		
	
	
	}
	
	
	

}
