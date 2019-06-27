package com.examen_1.b67156.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen_1.b67156.data.PlanDeEstudioData;
import com.examen_1.b67156.domain.PlanDeEstudio;
@Service
public class PlanEstudioBusiness {
	@Autowired
	PlanDeEstudioData planData;
	
	public PlanDeEstudio cargaPlanDeEstudio(String carrera){
		return planData.cargaPlanDeEstudio(carrera);
	}

//	public PlanDeEstudio guardar(PlanDeEstudio planEstudio) {
//		
//		return planData.guarda(planEstudio);
//	}
}
