package com.examen_1.b67156.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examen_1.b67156.DataBase.DataBase;
import com.examen_1.b67156.domain.PlanDeEstudio;
@Repository
public class PlanDeEstudioData {
	@Autowired
	AreaData areaData;
	
	public PlanDeEstudio cargaPlanDeEstudio( String carrera){
		PlanDeEstudio planDeEstudio = new PlanDeEstudio( DataBase.AREAS.iterator().next(), carrera);
		return planDeEstudio;
	}

//	public PlanDeEstudio guarda(PlanDeEstudio planEstudio) {
//		PlanDeEstudio planDeEstudio = new PlanDeEstudio("Innovacion", areaData.cargaArea().next());
//		return null;
//	}

}
