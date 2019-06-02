package com.proyectoUno.grupo5.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.domain.Metrics;

@RestController
public class MetricsControllerRest {
	@Autowired
	private MetricsBusiness metricBusiness;

	@RequestMapping(value="/api/metrics", method=RequestMethod.GET )
	public @ResponseBody List<Metrics> listMetrics()

	{
		return metricBusiness.getMetrics();
		
	}

}
