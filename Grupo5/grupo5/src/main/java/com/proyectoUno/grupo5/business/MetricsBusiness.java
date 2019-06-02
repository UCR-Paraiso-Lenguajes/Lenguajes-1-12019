package com.proyectoUno.grupo5.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.MetricsDao;
import com.proyectoUno.grupo5.domain.Metrics;


@Service
public class MetricsBusiness{

	 @Autowired
	    private MetricsDao metrics;	

	 
	   
	 public List<Metrics> getMetrics () {
	       return metrics.getMetrics();
	    	
	    }
	    

}
