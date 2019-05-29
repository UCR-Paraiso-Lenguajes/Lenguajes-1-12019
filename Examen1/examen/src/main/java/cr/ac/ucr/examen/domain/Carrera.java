package cr.ac.ucr.examen.domain;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Carrera {
	
	private String nombre;
	private ArrayList<Ciclo> cursos = new ArrayList<Ciclo>();
	private int totalCursos;
	private int totalCreditos;
	private ArrayList<Area> areas = new ArrayList<>();
		
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

	public void setCursos(ArrayList<Ciclo> cursos) {
		this.cursos = cursos;
	}

	public ArrayList<Ciclo> getCursos() {
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
	public ArrayList<Curso> cursosRequisitos(Curso curso){
		boolean si =false;
		ArrayList<ArrayList<Curso>> cursosRequisitos = new ArrayList<ArrayList<Curso>>();
		Stack<ArrayList<Curso>> temporal = new Stack<>();
		Iterator<Area> it = this.areas.iterator();
		ArrayList<Curso> listaCursosPorAreas =  it.next().getAreas().peek();
		
		
		while(it.hasNext()) {
			while(listaCursosPorAreas != null) {
				
				if(si) {
					cursosRequisitos.add(listaCursosPorAreas);
				}
				
				else {
				while(listaCursosPorAreas.iterator().hasNext()) {
					if(listaCursosPorAreas.iterator().next() == curso) 
					{
						si=true;
					}
				}
				}
				
				temporal.push(it.next().getAreas().pop());
			}
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
