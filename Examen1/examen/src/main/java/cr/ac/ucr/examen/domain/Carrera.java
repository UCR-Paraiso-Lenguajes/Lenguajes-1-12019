package cr.ac.ucr.examen.domain;


import java.util.ArrayList;
import java.util.Iterator;

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
		
		ArrayList<Curso> cursosRequisitos;
		boolean change= false;
		Iterator<Area> it = this.areas.iterator();
		
		while(it.hasNext()) {
			while(it.next().getAreas().iterator().hasNext()) {
				while(it.next().getAreas().iterator().next().iterator().hasNext()) {
					if(it.next().getAreas().iterator().next().iterator().next() == curso) 
					{
						change = true;
					}
					
				}
				
			}
		}
		change=false;
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
