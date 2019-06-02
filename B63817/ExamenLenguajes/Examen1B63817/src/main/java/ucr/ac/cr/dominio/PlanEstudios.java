package ucr.ac.cr.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlanEstudios {

	private String cantidadDeBloques;
	private String nombre;
	private Iterator<Curso> cursos;

	public PlanEstudios() {
	}

	public PlanEstudios(String cantidadDeBloques, Iterator<Curso> cursos) {
		super();
		if(cantidadDeBloques== null || cantidadDeBloques.trim().equals("")) throw new RuntimeException("El bloque es requerido");
		this.cantidadDeBloques = cantidadDeBloques;
		this.cursos = cursos;
	
		
		
	}

	public Iterator<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Iterator<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidadDeBloques() {
		return cantidadDeBloques;
	}

	public void setCantidadDeBloques(String cantidadDeBloques) {
		this.cantidadDeBloques = cantidadDeBloques;
	}

	@Override
	public String toString() {
		return "PlanEstudios [cantidadDeBloques=" + cantidadDeBloques + ", cursos=" + cursos + "]";
	}

}
