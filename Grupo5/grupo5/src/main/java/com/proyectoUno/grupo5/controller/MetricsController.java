package com.proyectoUno.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.domain.Metrics;



@Controller
public class MetricsController {
    @Autowired
    private MetricsBusiness metric;

    
    @RequestMapping(value = "/metric", method = RequestMethod.GET)
    public String showMetrics() {
        return "metrics";
    }
    

}
