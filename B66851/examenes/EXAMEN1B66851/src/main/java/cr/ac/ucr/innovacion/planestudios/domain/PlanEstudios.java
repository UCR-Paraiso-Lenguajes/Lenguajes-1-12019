package cr.ac.ucr.innovacion.planestudios.domain;

import java.util.List;

public class PlanEstudios {
	
	private int cantidadCursos;
	private int cantidadCreditos;
	private List cursos;
	
	public PlanEstudios(int cantidadCursos, int cantidadCreditos, List cursos) {
		super();
		this.cantidadCursos = cantidadCursos;
		this.cantidadCreditos = cantidadCreditos;
		this.cursos = cursos;
	}

	public int getCantidadCursos() {
		return cantidadCursos;
	}

	public void setCantidadCursos(int cantidadCursos) {
		this.cantidadCursos = cantidadCursos;
	}

	public int getCantidadCreditos() {
		return cantidadCreditos;
	}

	public void setCantidadCreditos(int cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}

	public List getCursos() {
		return cursos;
	}

	public void setCursos(List cursos) {
		this.cursos = cursos;
	}
	
	
	
	
	

}
