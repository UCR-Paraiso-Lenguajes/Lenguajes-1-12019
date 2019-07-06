package cr.ac.ucr.innovacion.planestudios.domain;

import java.util.List;

public class Curso {
	
	private String nombre;
	private String sigla;
	private int creditos;
	private String ciclo;
	private List<Curso> requisitos;
	
	public Curso(String nombre, String sigla, int creditos, String ciclo, List<Curso> requisitos) {
		super();
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
		this.ciclo = ciclo;
		this.requisitos = requisitos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<Curso> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Curso> requisitos) {
		this.requisitos = requisitos;
	}
	
	
	
}
