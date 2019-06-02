package ucr.ac.cr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ucr.ac.cr.dominio.Curso;
import ucr.ac.cr.logica.CarreraLogica;
import ucr.ac.cr.logica.CursoLogica;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarreraLogicaTest {


	@Test
	public void  cantidadDeCreditos() {
		CarreraLogica carreraLogica = new CarreraLogica();
		int creditos= 21;
		assertEquals(creditos, carreraLogica.cantidadDeCreditos());
		assertNotNull(creditos);
	}
	
		
	
	
	@Test
	public void  cantidadDeCursos() {
		CarreraLogica carreraLogica = new CarreraLogica();
		int creditos= 6;
		assertEquals(creditos, carreraLogica.cantidadDeCursos());
		assertNotNull(creditos);
	
	}
	
	@Test
	public void  agregarCursoAPlan(Curso curso)  {
		CarreraLogica carreraLogica = new CarreraLogica();
		Curso curso1 = new Curso("Teoría Organizacional 3", "IF200", 3, "1");
		Curso curso2 = new Curso("Gestión Pública", "IF201", 3, "3");
		Curso curso3 = new Curso("Gestión Social", "IF202", 3, "3");
		Curso curso4 = new Curso("Gestión de Proyectos", "IF203", 4, "3");
		Curso curso5 = new Curso("Gestión Estrátegia", "IF204", 4, "4");
		Curso curso6 = new Curso("Plan de Negocias", "IF205", 4, "5");
		
		ArrayList<Curso> requisito1 = new ArrayList<Curso>();
		ArrayList<Curso> requisito2 = new ArrayList<Curso>();
		ArrayList<Curso> requisito3 = new ArrayList<Curso>();
		requisito1.add(curso1);
		requisito2.add(curso2);
		requisito2.add(curso3);
		requisito2.add(curso4);
		requisito3.add(curso5);

		Iterator<Curso> requisitoUno = requisito1.iterator();
		Iterator<Curso> requisitoDos = requisito2.iterator();
		Iterator<Curso> requisitoTres = requisito3.iterator();

		curso2.setResiquisito(requisitoUno);
		curso3.setResiquisito(requisitoUno);
		curso4.setResiquisito(requisitoUno);
		curso5.setResiquisito(requisitoDos);
		curso5.setResiquisito(requisitoTres);

		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);
		cursos.add(curso6);
		Iterator<Curso> listacursos;
		listacursos = cursos.iterator();
		carreraLogica.agregarCursoAPlan(curso6);
		List<Curso> cursosListaPrueba =  (List<Curso>) carreraLogica.listarCursos();
		assertNotNull(cursosListaPrueba);
			assertTrue(!cursosListaPrueba.isEmpty());
		
		
	}
	
	
}