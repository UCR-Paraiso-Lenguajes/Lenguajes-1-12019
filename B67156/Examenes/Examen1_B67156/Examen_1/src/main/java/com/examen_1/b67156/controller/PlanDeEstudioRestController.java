package com.examen_1.b67156.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen_1.b67156.business.PlanEstudioBusiness;
import com.examen_1.b67156.domain.PlanDeEstudio;
@RestController
public class PlanDeEstudioRestController {
	@Autowired
	PlanEstudioBusiness planBusiness;
	
//	@RequestMapping(value="/api/carreras",method=RequestMethod.GET)
//	public @ResponseBody PlanDeEstudio listarCursos()
//	{
//		return planBusiness.cargaPlanDeEstudio();
//	}
	
//	@RequestMapping(value= "/api/carreras",method=RequestMethod.POST)
//	public @ResponseBody PlanDeEstudio insertarPlanEstudio (@RequestBody PlanDeEstudio planEstudio) 
//	{
//		planEstudio= planBusiness.guardar(planEstudio);
//		return planEstudio;
//	}


}
