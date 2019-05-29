package com.examen1.plan.estudios.domain;

import java.util.ArrayList;

public class PlanDeEstudios {
	
	private String nombre;
	private ArrayList<Ciclo> ciclos;
	
	
	public PlanDeEstudios(String nombre) {
		this.nombre = nombre;
		this.ciclos = new ArrayList<Ciclo>();
		agregarNuevoCiclo();
	}

	public void agregarRequisitoCurso(int idCiclo, String siglaCursoAgregar, String siglaCursoRequisito) {
		if(!existeCursoEnCiclosAnteriores(idCiclo - 2, siglaCursoRequisito))
			throw new RuntimeException("El plan de estudios no contiene el curso a asignar"
					+ " como requisito en los ciclos pasados");
		ciclos.get(idCiclo - 1).agregarRequisitoCurso(siglaCursoAgregar, siglaCursoRequisito);
	}
	
	public void agregarCurso(int idCiclo, Curso nuevoCurso) {
		if(existeCursoEnCiclosAnteriores(idCiclo - 1, nuevoCurso.getSiglas()) ||
		   existeCursoEnCiclosPosteriores(idCiclo , nuevoCurso.getSiglas()))
			throw new RuntimeException("El ya existe en el plan de estudio.");
		ciclos.get(idCiclo - 1).agregarCurso(nuevoCurso);
	}
	
	private boolean existeCursoEnCiclosPosteriores(int idCiclo, String siglaCursoRequisito) {
		if(idCiclo >= ciclos.size()) return false;
		
		if(ciclos.get(idCiclo).existeCursoEnCiclo(siglaCursoRequisito)) return true;
		
		return existeCursoEnCiclosPosteriores(idCiclo + 1, siglaCursoRequisito);
	}
	
	public int obtenerTotalCreditosDelPlan() {
		int total = 0;
		for (int i = 0; i < ciclos.size(); i++)
			total += ciclos.get(i).obtenerTotalCreditosDelCiclo();
		return total;
	}
	
	public int obtenerTotalCursosDelPlan() {
		int total = 0;
		for (int i = 0; i < ciclos.size(); i++)
			total += ciclos.get(i).obtenerTotalCursosDelCiclo();
		return total;
	}
	
	private boolean existeCursoEnCiclosAnteriores(int idCiclo, String siglaCursoRequisito) {
		if(idCiclo < 0) return false;
		
		if(ciclos.get(idCiclo).existeCursoEnCiclo(siglaCursoRequisito)) return true;
		
		return existeCursoEnCiclosAnteriores(idCiclo - 1, siglaCursoRequisito);
	}
	
	public void agregarNuevoCiclo(){
		ciclos.add(new Ciclo(ciclos.size()+1));
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals(""))
			throw new RuntimeException("El nombre no es valido!");
		this.nombre = nombre;
	}
	
}	
