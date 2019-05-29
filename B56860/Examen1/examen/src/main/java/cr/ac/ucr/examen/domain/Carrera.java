package cr.ac.ucr.examen.domain;


import java.util.Iterator;
import java.util.TreeSet;

public class Carrera {
	
	private String nombre;
	private TreeSet<Ciclo> cursos = new TreeSet<Ciclo>();
	private int totalCursos;
	private int totalCreditos;
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalCursos() {
		return totalCursos;
	}
	
	public void updateTotalCursos() {
		this.totalCursos++;
	}

	public void setCursos(TreeSet<Ciclo> cursos) {
		this.cursos = cursos;
	}

	public TreeSet<Ciclo> getCursos() {
		return cursos;
	}

	public int getTotalCreditos() {
		return totalCreditos;
	}

	//devuelve el total de creds por carrera
	public void updateTotalCreditos(int creds) {
		
			this.totalCreditos += creds;
	}

	
	//DADO UN CURSO ESPECÍFICO PUEDE CALCULAR CUÁLES CURSOS SON NECESARIOS PARA LLEVARLO 
	public Iterator<Ciclo> cursosRequisitos(Curso curso){
		while(cursos.iterator().hasNext()) {
			if(cursos.iterator().next().getCursosPorCiclo().contains(curso))
				return cursos.descendingIterator();
		}	
		throw new RuntimeException("El curso no pertenece al plan de estudios"); 
	}
	
	
	public void insertarCursosCarrera(Curso curso, Ciclo ciclo) {
		
		while(cursos.iterator().hasNext()) {
			if(cursos.iterator().next() == ciclo)	
				cursos.add(ciclo);
		}
		ciclo.getCursosPorCiclo().add(curso);
		
		
		updateTotalCreditos(curso.getCreditos());
		updateTotalCursos();
	}
	
}
