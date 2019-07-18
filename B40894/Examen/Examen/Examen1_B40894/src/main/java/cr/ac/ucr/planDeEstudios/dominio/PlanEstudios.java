package cr.ac.ucr.planDeEstudios.dominio;

import java.util.List;

public class PlanEstudios {

	private String nombre;
	private List<Curso>  cursos;
	private int totalCreditos;
	
	public PlanEstudios(String nombre, List<Curso> cursos, int totalCreditos) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
		this.totalCreditos = totalCreditos;
	}
	 
	public PlanEstudios() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public int getTotalCreditos() {
		return totalCreditos;
	}
	public void setTotalCreditos(int totalCreditos) {
		this.totalCreditos = totalCreditos;
	}
	
	
	
	
}
