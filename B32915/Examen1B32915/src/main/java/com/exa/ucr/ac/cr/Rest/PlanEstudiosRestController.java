package com.exa.ucr.ac.cr.Rest;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exa.ucr.ac.cr.Business.PlanEstudiosBusiness;
import com.exa.ucr.ac.cr.Domain.PlanEstudios;

@RestController
public class PlanEstudiosRestController {
	
	/*@Autowired PlanEstudiosBusiness planEst;
	Lo tenia con el annotation pero tira un error de bean */
	
	@RequestMapping(value="/api/carrera/plan", method=RequestMethod.PUT )
	public @ResponseBody void actualizarPlan(@RequestBody PlanEstudios plan){
		
		PlanEstudiosBusiness planEst = new PlanEstudiosBusiness();
		
		planEst.updatePlan(plan);
	}
	
	@RequestMapping(value="/api/carrera/plan/{name}", method=RequestMethod.DELETE )
	public @ResponseBody void eliminaPlan(@PathVariable String name){
		
		PlanEstudiosBusiness planEst = new PlanEstudiosBusiness();
		
		planEst.deletePlan(name);
	}
	
	@RequestMapping(value="/api/carrera/plan", method=RequestMethod.POST )
	public @ResponseBody void crearPlan(@RequestBody PlanEstudios plan){
		
		PlanEstudiosBusiness planEst = new PlanEstudiosBusiness();
		
		planEst.createPlan(plan);
	}
	
	@RequestMapping(value="/api/carrera/plan/{name}", method=RequestMethod.GET )
	public @ResponseBody PlanEstudios mostrarPlan(){
		
		PlanEstudiosBusiness planEst = new PlanEstudiosBusiness();
		
		return planEst.getPlan();
	}

}
