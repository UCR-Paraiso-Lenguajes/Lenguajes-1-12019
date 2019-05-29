package ucr.ac.cr.B76223.examen1.domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String nombre;
	private String siglas;
	private int creditos;
	private List<Curso> requisitos;

	public Curso(String nombre, String siglas, int creditos, List<Curso> requisitos) {

		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.requisitos = requisitos;
	}

	public Curso(String nombre, String siglas, int creditos) {

		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<Curso> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Curso> requisitos) {
		this.requisitos = requisitos;
	}

	public void insertarCursoPlan(String plan, Curso curso) {
		List<Plan> listaPlanes = new ArrayList<>();
		for (int i = 0; i < listaPlanes.size(); i++) {
			if (listaPlanes.get(i).getNombre().equals(plan))
		
			listaPlanes.get(i).getCursos().add(curso);
		}
	}

	public void insertarCursoRequisitos(Curso curso, Curso cursoRequisito) {
		List<Curso> listaCursoRequisitos = curso.getRequisitos();	
		listaCursoRequisitos.add(cursoRequisito);
	}

}
