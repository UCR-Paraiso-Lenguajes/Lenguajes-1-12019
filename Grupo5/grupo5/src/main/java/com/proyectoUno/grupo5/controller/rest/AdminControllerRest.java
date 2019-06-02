package com.proyectoUno.grupo5.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.Room;

@RestController
public class AdminControllerRest {
	@Autowired
	private MetricsBusiness metricBusiness;
	
	@Autowired
	private RoomBussiness roomBusiness;
	
	
	

	@RequestMapping(value="/admin/{admin_user}", method=RequestMethod.GET )
	public @ResponseBody List<Metrics> listMetrics()

	{
		return metricBusiness.getMetrics();
		
	}

	
	@RequestMapping(value="/admin/{admin_user}/principal", method=RequestMethod.GET )
	public @ResponseBody List<Room> listRooms()

	{
	return roomBusiness.getRooms();
		
	}
}
