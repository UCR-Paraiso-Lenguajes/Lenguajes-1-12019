package com.proyectoUno.grupo5.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.MetricsDao;
import com.proyectoUno.grupo5.domain.Metrics;


@Service
public class MetricsBusiness{

	 @Autowired
	    private MetricsDao metrics;	

	 public List<Metrics> getMetrics () throws SQLException {
	       return metrics.getMetrics();
	    }

	 public void update() 
		{
							
		 metrics.updateMetrics();
		}
}
