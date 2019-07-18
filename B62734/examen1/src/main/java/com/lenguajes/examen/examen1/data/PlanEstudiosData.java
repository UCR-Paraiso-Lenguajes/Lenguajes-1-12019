package com.lenguajes.examen.examen1.data;

import java.util.ArrayList;

import com.lenguajes.examen.examen1.domain.Curso;
import com.lenguajes.examen.examen1.domain.CursoConRequisitos;
import com.lenguajes.examen.examen1.domain.CursoInicial;
import com.lenguajes.examen.examen1.domain.PlanEstudios;

public class PlanEstudiosData {
	public ArrayList<Curso> mantenerEstado() {
		Curso cursoProgramacion1=new CursoInicial("programacion1", "if-2000",4);
		Curso cursoProgramacion2=new CursoInicial("programacion2", "if-3000",3);
		
		Curso cursoHumanidades1=new CursoInicial("humanidades1", "hum-2000",4);
		Curso cursoHumanidades2=new CursoInicial("humanidades2", "if-3000",3);
		
		Curso cursoLogica=new CursoInicial("logica", "if-2100",4);
		Curso cursoProgramacion5=new CursoInicial("programacion5", "if-5000",3);
		
		CursoConRequisitos cursoConRequisitos=new CursoConRequisitos("SistemasOperativos", "if-4000", 4);
		ArrayList<Curso> cursos=new ArrayList<Curso>();
		cursos.add(cursoProgramacion1);
		cursos.add(cursoProgramacion2);
		cursos.add(cursoProgramacion5);
		cursos.add(cursoHumanidades1);
		cursos.add(cursoHumanidades2);
		cursos.add(cursoLogica);
		
		cursoConRequisitos.setRequisitos(cursos);
		
		PlanEstudios planEstudios=new PlanEstudios("informatica Empresarial"); 
		
		cursos.add(cursoConRequisitos);
		planEstudios.setCursosPlan(cursos);
		
		return planEstudios.listaRequisitos(cursoConRequisitos);
	}
}
