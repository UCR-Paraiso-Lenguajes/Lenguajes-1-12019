package com.examen1b53953.data;

import java.util.ArrayList;
import java.util.List;

import com.examen1b53953.domain.Curso;

public class CursoData {

	
	private ArrayList<Curso> cursos;
	private Curso curso;
	
	public List<Curso> listarCursos() {
		
		return cursos;
	}

	public void guardarCurso(Curso curso) {
		
		if (!existeCurso(curso)) {
			cursos.add(curso);
        }
		
	}

	
	public boolean existeCurso(Curso curso) {
        boolean existe = false;
        for (int i = 0; i < cursos.size(); i++) {
            Curso cursoTemp = cursos.get(i);
            if (cursoTemp.getId() == (curso.getId())) {
                existe = true;
            }

        }
        return existe;
    }
	
	 public void actualizarCurso(Curso curso, Curso cursoAtualizado){
	        for (int i = 0; i < cursos.size(); i++) {
	            Curso temp = cursos.get(i);
	           
	            if(temp.getId() == curso.getId()){
	                cursos.set(i, cursoAtualizado);
	               
	            }
	        }
	    }
	

	 public Curso agregarRequisitoAlCurso(Curso curso, ArrayList<Curso> cursosR) {
		curso.getRequisitos().addAll(cursosR);
		return curso;
	 }
	 
	 public void eliminarCurso(int id) {
	       
	        for (int i = 0; i < cursos.size(); i++) {
	            Curso cursoTemp = cursos.get(i);
	            if(cursoTemp.getId()==id){
	                cursos.remove(i);
	            }
	        }
	 }


}
