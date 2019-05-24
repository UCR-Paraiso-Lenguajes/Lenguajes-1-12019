package com.proyectoUno.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoUno.grupo5.business.MetricsBusinessRoom;
import com.proyectoUno.grupo5.domain.MetricsRooms;

public class MetricsRoomController {
	 
	@Autowired
    private MetricsBusinessRoom metricRoom;
    
    @RequestMapping(value = "/metricRoom", method = RequestMethod.GET)
    public String showMetricsRoom(Model model) {
        List<MetricsRooms> list = metricRoom.getMetricsRoom();
        model.addAttribute("metricsRoom", list);
        return "prueba";
    }
}
