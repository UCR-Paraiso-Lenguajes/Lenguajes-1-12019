package ucr.ac.cr.B76223.examen1.domain;

import java.util.List;

public class Plan {

	private String nombre; 
	private int cantidadCursos; 
	private List<Curso> cursos;
	
	public Plan () {
	}
	
	public Plan(String nombre, int cantidadCursos, List<Curso> cursos) {
		this.nombre = nombre;
		this.cantidadCursos = cantidadCursos;
		this.cursos = cursos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadCursos() {
		return cantidadCursos;
	}

	public void setCantidadCursos(int cantidadCursos) {
		this.cantidadCursos = cantidadCursos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	} 
	
	
	
	
}
