package com.projectOne.interactiveMessaging.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.bussines.UserBusiness;
import com.projectOne.interactiveMessaging.domain.Metrics;


@Controller
public class MetricsController {
	
	@Autowired
	private MetricsBusiness metricsBusiness;
	
	@RequestMapping(value="/metrics", method=RequestMethod.GET)
    public String metrics(Model model) {
//		Iterator<Metrics> metrics = metricsBusiness.recoverMetricsData();
//		model.addAttribute("metrics", metrics.next());
		return "metrics";
    }
}
