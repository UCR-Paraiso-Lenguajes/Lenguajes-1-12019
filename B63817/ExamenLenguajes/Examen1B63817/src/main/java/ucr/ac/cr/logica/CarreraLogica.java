package ucr.ac.cr.logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ucr.ac.cr.dominio.Carrera;
import ucr.ac.cr.dominio.Curso;
import ucr.ac.cr.dominio.PlanEstudios;
import com.google.common.collect.Lists;

public class CarreraLogica {

	@Autowired
	Carrera carrera;

	public Carrera carrera2 = carreraEstudiosEstado();
	Iterator<Curso> listacursos;
	public PlanEstudios planEstudios = new PlanEstudios("6", listacursos);

	public Carrera carreraEstudiosEstado() {

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

		listacursos = cursos.iterator();

		Carrera carrera = new Carrera(planEstudios, "Estrategia e innovación");
		return carrera;

	}

	public int cantidadDeCreditos() {

		int cantidadCreditos = 0;
		Iterator<Curso> cursoIterator = carrera.getPlanEstudios().getCursos();
		List<Curso> cursoLista = Lists.newArrayList(cursoIterator);

		for (int i = 0; i < cursoLista.size(); i++) {

			cantidadCreditos = +cursoLista.get(i).getCreditos();

		}

		return cantidadCreditos;
	}

	public int cantidadDeCursos() {

		int cantidadCreditos = 0;
		Iterator<Curso> cursoIterator = carrera.getPlanEstudios().getCursos();
		List<Curso> cursoLista = Lists.newArrayList(cursoIterator);

		return cursoLista.size();
	}

	public void agregarCursoAPlan(Curso curso) {

		List<Curso> cursoLista = Lists.newArrayList(carrera2.getPlanEstudios().getCursos());

		List<Curso> requisitosLista = Lists.newArrayList(curso.getResiquisito());
		List<Curso> requisitosListaTemp = Lists.newArrayList(carrera2.getPlanEstudios().getCursos());
		for (int i = 0; i < requisitosLista.size(); i++) {

			if (requisitosLista.get(i).getNombre().equalsIgnoreCase(curso.getNombre()))
				throw new RuntimeException("El nombre es igual");
			if (requisitosLista.get(i).getBloque().equals(planEstudios.getCantidadDeBloques()))
				throw new RuntimeException("El requisito es un curso final");

		}

		cursoLista.add(curso);
		planEstudios.setCursos((Iterator<Curso>) cursoLista);
		

	}

	public void actualizar(String nombre, Carrera carrera3) {

	}

	public Iterator<Curso> listarCursos() {

		return carrera.getPlanEstudios().getCursos();
	}

}
