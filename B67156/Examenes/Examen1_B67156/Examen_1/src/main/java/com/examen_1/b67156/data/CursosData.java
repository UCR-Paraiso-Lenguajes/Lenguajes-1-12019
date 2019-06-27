package com.examen_1.b67156.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examen_1.b67156.DataBase.DataBase;
import com.examen_1.b67156.domain.Curso;
@Repository
public class CursosData {
	
	public void cargaCursos (){
		Curso curso5 = new Curso("Teoria Organizacional", "TO", 3,0);
		Curso curso4 = new Curso("Gestion de Proyectos", "GPro", 4,2);
		Curso curso3 = new Curso("Gestion Social", "GS", 3,2);
		Curso curso2 = new Curso("Gestion Publica 3", "GP", 3,2);
		Curso curso1 = new Curso("Gestion Estrategica 4","GE" , 4,3);
		Curso cursoFinal = new Curso("Plan de Negocio 4", "PN4", 4,4);
		DataBase.CURSOS.add(curso5);
		DataBase.CURSOS.add(curso4);
		DataBase.CURSOS.add(curso3);
		DataBase.CURSOS.add(curso2);
		DataBase.CURSOS.add(curso1);
		DataBase.CURSOS.add(cursoFinal);
	}
	
	public List<Curso> CrearCurso(Curso curso) {
		DataBase.CURSOS.add(curso);
		return DataBase.CURSOS;
	}

}
