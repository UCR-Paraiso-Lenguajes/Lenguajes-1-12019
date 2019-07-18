package com.examen.b24075.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.b24075.business.PlanBusiness;
import com.examen.b24075.domain.Plan;


@RestController
public class PlanController {
	
	@Autowired
	private PlanBusiness planBusiness;
	
	
	@RequestMapping(value="/UCR/API/CARRERAS/{plan}", method=RequestMethod.GET )
	public @ResponseBody int cursosPorPlan(
			@PathVariable String plan )
	{
		return PlanBusiness.cursosPorPlan(plan);
	}

	@RequestMapping(value="/UCR/API/CARRERAS/", method=RequestMethod.POST )
	public @ResponseBody  Plan guardarPlan(@RequestBody Plan plan)
	{
		
		
		return  PlanBusiness.guardarPlan(plan);
	}	

	@RequestMapping(value="/UCR/API/CARRERAS/{plan}", method=RequestMethod.PUT )
	public @ResponseBody void actualizarPlan(
			@RequestBody Plan plan )
	{
		  PlanBusiness.actualizarPlan(plan);
	}	
	
	
	@RequestMapping(value="/UCR/API/CARRERAS/{plan}", method=RequestMethod.DELETE )
	public @ResponseBody void eliminarPlan(
			@RequestBody Plan plan )
	{
		  PlanBusiness.eliminarPlan(plan);
	}
	


}
