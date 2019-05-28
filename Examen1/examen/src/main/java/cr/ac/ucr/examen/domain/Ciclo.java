package cr.ac.ucr.examen.domain;

import java.util.ArrayList;

public class Ciclo{
	
	private int numCiclo;
	private ArrayList<Curso> cursosPorCiclo = new ArrayList<>();
	
	
	public Ciclo() {
		numCiclo++;
	}

	public int getNumCiclo() {
		return numCiclo;
	}

	public void setNumCiclo(int numCiclo) {
		this.numCiclo = numCiclo;
	}

	public ArrayList<Curso> getCursosPorCiclo() {
		return cursosPorCiclo;
	}

	public void setCursosPorCiclo(ArrayList<Curso> cursosPorCiclo) {
		this.cursosPorCiclo = cursosPorCiclo;
	}

	
}