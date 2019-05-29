package Business;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import Domain.Curso;
import Domain.PlanEstudios;

public class CursoBusiness {
	
	private List<Curso> cursos = new ArrayList<Curso>();

	public void insertarCurso(Curso curso) {
		
		if(curso!=null) {
		cursos.add(curso);
		} throw new RuntimeException("El curso que se pretende insertar, no es válido.");
	}
	
	//son los requisitos para un nuevo curso
	public void insertarCursoRequisitos(Curso curso, List<Curso> cursosRequisito) {
		
		ArrayList<Curso> cursosR= new ArrayList<Curso>();
		if(cursosRequisito!=null) {
			cursosR=(ArrayList<Curso>) cursosRequisito;
			for (int i = 0; i < cursosR.size(); i++) {
				if(insertarRequisitos(cursosR.get(i))!=null) {
					curso.setCursosRequisito(cursosRequisito);
					insertarCurso(curso);
				}
			}
			
		} throw new RuntimeException("No hay requisitos que agregar.");

	}
	
	public List<Curso> insertarRequisitos(Curso cursoRequisito) {
		List<Curso> cursosRequisito = new ArrayList<Curso>();
		//Caso 1: El curso es del bloque inicial :. Por lo que no puede tener requisitos.
			if(!cursoRequisito.isBloqueFinal()) {
				cursoRequisito.setCursosRequisito(cursoRequisito.getCursosRequisito());
				cursosRequisito.add(cursoRequisito);
				//Caso 2: El curso es del bloque final :. No puede Ser requisito. 
				if(esValidoRequerido(cursoRequisito)) {
					cursosRequisito.add(cursoRequisito);
					return cursosRequisito;
				}throw new RuntimeException("El curso es del primer bloque, no puede tener requisitos.");
			} throw new RuntimeException("El curso es del primer bloque, no puede tener requisitos.");
	
	}
	
	public boolean esValidoRequerido(Curso curso) {
		 if(curso.isBloqueFinal()) {
			 return true;
		 } throw new RuntimeException("El curso no puede ser un requisito");
	}
	
	public List<Curso> listarCursosPorPlan(){
		List<Curso> listaCursos= new ArrayList<Curso>();
		
		for (int i = 0; i < cursos.size(); i++) {
			listaCursos.add(cursos.get(i));
		}
		
		return listaCursos;
		
	}
	
	public void eliminarCurso(Curso curso) {
		
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getSigla().equals(curso.getSigla())) {
				cursos.remove(curso);
			} throw new RuntimeException("El curso no se encuentra en la lista de cursos.");
		}
	}
	
	public void editarCurso(Curso curso) {
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getSigla().equals(curso.getSigla())) {
				cursos.get(i).setNombre(curso.getNombre());
				cursos.get(i).setCreditos(curso.getCreditos());
			}throw new RuntimeException("El curso no se encuentra en el sistema.");
		}
	}
	
	public void actualizarEstado() {
		this.cursos=cursos;
	}

}
