package com.projectOne.interactiveMessaging.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.domain.Metrics;

@Controller
public class MetricsUserControllers {
	@Autowired
	MetricsBusiness metricBusiness;
	
	@RequestMapping(value="/metricsForGroup", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "metricsForGroup";
	}
	
	@RequestMapping(value="/metricsForGroup", method=RequestMethod.POST)
	public String mantenimientoAutores (Model model, @RequestParam("idMetrics") int idMetrics) {
		Iterator<Metrics> metrics = metricBusiness.findMetrics(idMetrics);
		model.addAttribute("metrics", metrics);
		return "metricsForGroup";
	}
	

}
