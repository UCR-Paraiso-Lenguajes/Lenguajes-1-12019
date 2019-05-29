package com.prueba.B77436.business;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.B77436.controller.PlanEstudiosController;
import com.prueba.B77436.domain.Carrera;
import com.prueba.B77436.domain.Ciclo;
import com.prueba.B77436.domain.Curso;
import com.prueba.B77436.domain.PlandeEstudios;

@Service
public class CursoBusiness {
	
	
	
	
	public int cantidadCreditos(ArrayList<Curso> cursos) {
		int creditos=0;
		for(int i=0;i<cursos.size();i++)
			creditos+=cursos.get(i).getCreditos();
		return creditos;
		
	}
	
	public int cantidadCursos(ArrayList<Curso> cursos) {
		
		return cursos.size();
		
	}
	
	public Iterator<Curso> calculaRequesitosCurso(Curso curso, PlandeEstudios plan){
		ArrayList<Integer> requesitos = curso.getRequisitos();
		ArrayList<Curso> cursosRequisito = new ArrayList<Curso>();
		for(int i=0;i<requesitos.size();i++) {
			for(int c=0;c<plan.getCursos().size();c++) {
				if(requesitos.get(i)==plan.getCursos().get(c).getIdCurso())
					cursosRequisito.add(plan.getCursos().get(c));
			}
		}
		
		return cursosRequisito.iterator();
	}
	
	
	

}
