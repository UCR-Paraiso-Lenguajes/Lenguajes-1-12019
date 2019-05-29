package com.ucr.ac.cr.planDeEstudios.business;

import org.springframework.stereotype.Service;

import com.ucr.ac.cr.planDeEstudios.data.CursoData;
import com.ucr.ac.cr.planDeEstudios.domain.Curso;

@Service
public class CursoBusiness {

	private CursoData cursoDao;

	public boolean insertarCurso(Curso curso) {

		return cursoDao.insertarCurso(curso);
	}

	public void editarCurso(Curso curso) {

		cursoDao.editarCurso(curso);

	}

	public void delete(int idCurso) {

		cursoDao.delete(idCurso);
	}

}
