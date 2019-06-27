package com.ucr.ac.cr.Examen1.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucr.ac.cr.Examen1.data.PlanEstudiosData;
import com.ucr.ac.cr.Examen1.domain.Curso;

public class PlanEstudiosBusiness {
	
	@Autowired
	PlanEstudiosData planDao;

	public void llenarLista() {
		planDao.llenarLista();
		
	}
	
	public void insertarCurso(Curso curso) {
		planDao.insertarCurso(curso);
	}
	
	public ArrayList<Curso> insertarCursoRequisitos(Curso curso){
		return insertarCursoRequisitos(curso);
	}
	
	public boolean existe(Curso curso) {
		return existe(curso);
	}
	
	public ArrayList<Curso> buscarRequisitosExistente(Curso curso){
		return buscarRequisitosExistente(curso);
	}
}
