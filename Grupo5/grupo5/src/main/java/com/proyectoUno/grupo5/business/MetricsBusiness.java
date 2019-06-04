package com.proyectoUno.grupo5.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.MetricsDao;
import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.User;


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

	public void delete(int id_room, int id_user) {
		
		metrics.delete(id_room, id_user);
	}

	public void promoteUser(int id_room, int id_user) {
		metrics.promoteUser(id_room, id_user);
		
	}
}
