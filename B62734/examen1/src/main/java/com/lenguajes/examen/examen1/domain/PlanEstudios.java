package com.lenguajes.examen.examen1.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.lenguajes.examen.examen1.excepciones.CursoException;
import com.lenguajes.examen.examen1.excepciones.PlanEstudiosException;

public class PlanEstudios {
	private static int cont=0;
	private int id;
	private String nombre;
	private List<Curso> cursosPlan;
	 static ArrayList<Curso> requisitosTotales=new ArrayList<Curso>();

	public PlanEstudios(String nombre) {
		super();
		cont=cont+1;
		this.id=cont;
		if (nombre==null) {
			throw new PlanEstudiosException("el plan de estudios no puede estar vacio");
		}
		
		this.nombre = nombre;
		cursosPlan=new ArrayList<Curso>();
		
	}

	public PlanEstudios(String nombre,int creditosTotales,List<Curso> cursosPlan) {
		super();
		cont=cont+1;
		this.id=cont;
		if (nombre==null || cursosPlan==null) {
			throw new PlanEstudiosException("el plan de estudios no puede estar vacio");
		}
		this.nombre = nombre;
		this.cursosPlan = cursosPlan;
	}
	public void agregarCurso(Curso Curso) {
		if (cursosPlan.contains(Curso)) {
			throw new CursoException("el curso ya existe");
		}else {
			cursosPlan.add(Curso);
		}
	}
	public void actualizar(Curso CursoViejo,Curso CursoNuevo) {
		if (!cursosPlan.contains(CursoViejo)) {
			throw new CursoException("el curso no existe");
		}else {
			cursosPlan.set(cursosPlan.indexOf(CursoViejo), CursoNuevo);
		}
	}
	public void delete(String nombre) {
		Curso curso=getCursoPorNombre(nombre);
		if (!cursosPlan.contains(curso)) {
			throw new CursoException("el curso ya existe");
		}else {
			cursosPlan.remove(curso);
		}
	}
	public Curso getCursoPorNombre(String nombre) {
		Curso curso=null;
		for (int cursosCuenta = 0; cursosCuenta < cursosPlan.size(); cursosCuenta++) {
			if (cursosPlan.get(cursosCuenta).getNombre().equals(nombre)) {
				curso=cursosPlan.get(cursosCuenta);
			}
		}
		return curso;
	}
	public ArrayList<Curso> listar() {
		return (ArrayList<Curso>) cursosPlan;
	}
	public int totalCursosPlan() {
		return cursosPlan.size();
	}
	public int totalCreditos() {
		int totalCreditos=0;
		if (cursosPlan.size()>0){
			for (int cuentaCurso = 0; cuentaCurso < cursosPlan.size(); cuentaCurso++) {
				Curso curso=cursosPlan.get(cuentaCurso);
				totalCreditos +=cursosPlan.get(cuentaCurso).getCreditos();
			}
		}
	return totalCreditos;
	}
	public ArrayList<Curso> listaRequisitos(Curso curso){
		if (curso instanceof CursoInicial) {
			requisitosTotales.add(curso);
	
		}
		else if (curso instanceof CursoConRequisitos) {
			curso=(CursoConRequisitos) curso;
			if (((CursoConRequisitos) curso).getRequisitos().isEmpty()) {				
				requisitosTotales.add(curso);
			}else {
				
					requisitosTotales.add(cursoRecursivo(curso));
			}
		}		
				
		return  requisitosTotales;
	}
	public Curso cursoRecursivo(Curso curso) {
		if (curso instanceof CursoInicial) {
			return curso;
	
		}else if (curso instanceof CursoConRequisitos) {
			curso=(CursoConRequisitos) curso;
			ArrayList<Curso> requisitos= (ArrayList<Curso>) ((CursoConRequisitos) curso).getRequisitos();
			if (requisitos.isEmpty()) {
				return curso;

			}else {
				for (int i = 0; i < requisitos.size(); i++) {
					Curso cursoRequisito=requisitos.get(i);
					requisitosTotales.add(cursoRequisito);

					return cursoRecursivo(cursoRecursivo(cursoRequisito));

				}	
			}
			
		}
		return curso;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Curso> getCursosPlan() {
		return cursosPlan;
	}

	public void setCursosPlan(List<Curso> cursosPlan) {
		this.cursosPlan = cursosPlan;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
