package com.lenguajes.examen.examen1.rest;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenguajes.examen.examen1.business.PlanEstudiosBusiness;
import com.lenguajes.examen.examen1.domain.PlanEstudios;

@RestController
public class PlanEstudiosRestController {
	PlanEstudiosBusiness planEstudiosBusiness=new PlanEstudiosBusiness();
	
 	@RequestMapping(value="/api/carreras/{carrera}", method=RequestMethod.POST )
	public @ResponseBody void Crear(
			@RequestBody String carrera){
 		PlanEstudios planEstudios=new PlanEstudios(carrera);
		planEstudiosBusiness.crear(planEstudios);
	}
 	@RequestMapping(value="/api/eliminarCarrera/{carrera}", method=RequestMethod.DELETE)
	public @ResponseBody void eliminar(
			@RequestBody String carrera){		
		planEstudiosBusiness.delete(carrera);
	}
 	@RequestMapping(value="/api/updateCarrera/{planEstudios}/{planEstudiosNuevo}", method=RequestMethod.PUT )
	public @ResponseBody void actualizar(
			@RequestBody PlanEstudios planEstudios,
			@RequestBody PlanEstudios planEstudiosNuevo){
 		
		planEstudiosBusiness.actualizar(planEstudios,planEstudiosNuevo);
	}
 	@RequestMapping(value="/api/listarCarrera/", method=RequestMethod.GET )
	public @ResponseBody ArrayList<PlanEstudios> listar(){
 		
		return planEstudiosBusiness.listar();
	}
}
