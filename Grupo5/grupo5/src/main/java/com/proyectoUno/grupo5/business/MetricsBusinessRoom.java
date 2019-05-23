package com.proyectoUno.grupo5.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoUno.grupo5.dao.MetricsDaoRoom;
import com.proyectoUno.grupo5.domain.MetricsRooms;

public class MetricsBusinessRoom {
	
	 @Autowired
    private MetricsDaoRoom metricsRoom;
	
	 public List<MetricsRooms> getMetricsRoom () {
	       return metricsRoom.getMetricsRoom();
	    
	    }

}
