package com.proyectoUno.grupo5.controller.rest;

import java.sql.SQLException;
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
	
	
	

	@RequestMapping(value="/admin/metrics", method=RequestMethod.GET )
	public @ResponseBody List<Metrics> listMetrics() throws SQLException

	{
		return metricBusiness.getMetrics();
		
	}

	
	@RequestMapping(value="/api/metrics", method=RequestMethod.PUT )
	public @ResponseBody void updateMetrics()
	{
		metricBusiness.update();
	}	
}
