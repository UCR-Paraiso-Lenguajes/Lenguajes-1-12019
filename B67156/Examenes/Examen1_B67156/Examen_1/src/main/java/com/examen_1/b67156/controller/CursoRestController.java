package com.examen_1.b67156.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen_1.b67156.data.AreaData;
import com.examen_1.b67156.domain.Area;
import com.examen_1.b67156.domain.PlanDeEstudio;

@RestController
public class CursoRestController {
	
	@Autowired
	private AreaData areadata;
	
	@RequestMapping(value= "/api/carreras",method=RequestMethod.POST)
	public @ResponseBody PlanDeEstudio insertarPlanEstudio (@RequestBody PlanDeEstudio planEstudio) 
	{
		return planEstudio;
	}
	
//	@RequestMapping(value="/api/carreras",method=RequestMethod.GET)
//	public @ResponseBody Area listarCursos()
//	{
//		return areadata.cargaArea();
//	}
	

}
