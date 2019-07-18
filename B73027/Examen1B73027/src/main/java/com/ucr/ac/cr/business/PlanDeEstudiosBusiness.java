package com.ucr.ac.cr.business;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucr.ac.cr.data.DatosEnMemoria;
import com.ucr.ac.cr.domain.Curso;
import com.ucr.ac.cr.domain.PlanDeEstudios;

public class PlanDeEstudiosBusiness {
	
	@Autowired
	PlanDeEstudios plan;
	
	DatosEnMemoria datos = new DatosEnMemoria();
	
	
	public void insertarCursos(Curso curso) {
		
		for (int i = 0; i < curso.getRequisitosCurso().size(); i++) {
			if(curso.getRequisitosCurso().get(i).contentEquals(curso.getSiglasCurso())) {
				 throw new RuntimeException("NO SE PERMITE LA CREACIÓN DE UN CURSO Y ÉL MISMO COMO REQUISITO");
			}
		}
		
		datos.cursos.add(curso);
		plan = new PlanDeEstudios("Informatica", datos.cursos);
		
		
	}
	
	
	//AL PLAN DE ESTUDIOS SE LE PUEDE PREGUNTAR CUÁNTOS CURSOS TIENE
	public int numersoDeCursos (PlanDeEstudios plan) {
		
		
		int numeroCursos = plan.getCursosPlan().size();
		return numeroCursos;
	}
	
	//CRÉDITOS TOTALES REQUIERE. 
	
	public int totalCreditos (PlanDeEstudios plan) {
		
		int total=0;
		for(int i=0; i<plan.getCursosPlan().size(); i++) {
			total += plan.getCursosPlan().get(i).getCreditosCurso();
		}
		
		return total;
	}
	
	
	/*DADO UN CURSO ESPECÍFICO PUEDE CALCULAR CUÁLES CURSOS
	SON NECESARIOS PARA LLEVARLO DE MANERA RECURSIVA HASTA CONSIDERAR LOS CURSOS
	INICIALES.*/
	
	public String cursosNecesarios(String siglas){
		
		datos.datos();
		
		String necesario = "";
		
		
		for(int i=0; i<datos.cursos.size(); i++) {
			if( datos.cursos.get(i).getSiglasCurso().equals(siglas) ){
				
				necesario = "" + datos.cursos.get(i).getRequisitosCurso() + "\n";
			}
			
		}
		
		
		return necesario ;
	}
	
	public String cursoFinal(int numCiclo) {
		datos.datos();
		ArrayList<Curso> listacurso = new ArrayList<Curso>();
		String estado= "";
		
		for(int i=0; i< datos.cursos.size(); i++) {
			
			if( datos.cursos.get(i).getNumCiclo() == numCiclo ){
				listacurso.add(datos.cursos.get(i));

			}
		}
			/*for (int j = 0; j < listacurso.size(); j++) {
				
				if (listacurso.get(j).getRequisitosCurso().get(index)) {
					estado += "el Curso "+listacurso.get(j).getNombreCurso()+" si posee requerimientos"+"\n";
				}else {
					estado += "el Curso "+listacurso.get(j).getNombreCurso()+" no posee requerimientos"+"\n";
				}
				
			}
			
			*/
		
		
		return estado;
		
	}
	
	
}
