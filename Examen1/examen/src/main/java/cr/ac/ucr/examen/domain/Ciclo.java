package cr.ac.ucr.examen.domain;

import java.util.ArrayList;

public class Ciclo{
	
	private int numCiclo;
	private ArrayList<Curso> cursosPorCiclo = new ArrayList<>();
	private int totalCreditosPorCiclo;
	
	public Ciclo() {
		numCiclo++;
	}

	public int getNumCiclo() {
		return numCiclo;
	}

	public void setNumCiclo(int numCiclo) {
		this.numCiclo = numCiclo;
	}

	public void setTotalCreditosPorCiclo(int totalCreditosPorCiclo) {
		this.totalCreditosPorCiclo = totalCreditosPorCiclo;
	}

	public ArrayList<Curso> getCursosPorCiclo() {
		return cursosPorCiclo;
	}

	public void setCursosPorCiclo(ArrayList<Curso> cursosPorCiclo) {
		this.cursosPorCiclo = cursosPorCiclo;
	}


	public int getTotalCreditosPorCiclo() {
		return totalCreditosPorCiclo;
	}
	
	//trae total de creds por ciclo
	public int updateTotalCreditosPorCiclo() {
		while(cursosPorCiclo.iterator().hasNext()) {
			totalCreditosPorCiclo += cursosPorCiclo.iterator().next().getCreditos();
		}	
		return totalCreditosPorCiclo;
	}
	
}