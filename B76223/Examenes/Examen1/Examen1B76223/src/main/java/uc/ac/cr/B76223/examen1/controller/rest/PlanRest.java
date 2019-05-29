package uc.ac.cr.B76223.examen1.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import ucr.ac.cr.B76223.examen1.business.PlanBusiness;
import ucr.ac.cr.B76223.examen1.domain.Plan;

@RestController
public class PlanRest {

	@Autowired
	PlanBusiness planBusiness; 
	
	@RequestMapping(value="/com/UCR/API/Carrera/Plan/{plan}", method=RequestMethod.DELETE)
	public @ResponseBody String borrarPlan(@RequestBody Plan plan)
	{
		return planBusiness.borrarPlan(plan.getNombre());
	}
	
	@RequestMapping(value="/com/UCR/API/Carrera/Plan/{plan}", method=RequestMethod.PUT)
	public @ResponseBody Plan insertarPlan(@RequestBody Plan plan)
	{
		
		return planBusiness.insertarPlan(plan);
	}
	
	@RequestMapping(value="/com/UCR/API/Carrera/Plan/{plan}", method=RequestMethod.PUT)
	public @ResponseBody Plan actualizarPlan(@RequestBody Plan plan)
	{
		return planBusiness.actualizarPlan(plan);
	}
	
	@RequestMapping(value="/com/UCR/API/Carrera/Plan/{plan}", method=RequestMethod.PUT)
	public @ResponseBody Plan listarPlan(@RequestBody Plan plan)
	{
		return planBusiness.listarPlan(plan.getNombre());
	}
	
}
