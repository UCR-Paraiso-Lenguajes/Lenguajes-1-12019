package com.examen_1.b67156.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examen_1.b67156.DataBase.DataBase;
import com.examen_1.b67156.domain.Area;
import com.examen_1.b67156.domain.Curso;
@Repository
public class AreaData {
	@Autowired
	private CursosData cursoData;
	
	public void cargaArea() {
		Area area = new Area("Estrategia e innovacion", "Informatica");
		while(DataBase.CURSOS.iterator().hasNext()) {
			Curso curso=DataBase.CURSOS.iterator().next();
			area.insertarRelaciones(curso);
		}
		DataBase.AREAS.add(area);
		
	}
	

}
