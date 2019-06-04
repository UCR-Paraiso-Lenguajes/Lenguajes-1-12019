package com.proyectoUno.grupo5.controller.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MetricsBusiness;
import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.business.UserBusiness;
import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

@RestController
public class AdminControllerRest {
	@Autowired
	private MetricsBusiness metricBusiness;
	
	@Autowired
	private RoomBussiness roomBusiness;
	
	@Autowired
	private UserBusiness userBusiness;
	

	@RequestMapping(value="/admin/metrics", method=RequestMethod.GET )
	public @ResponseBody List<Metrics> listMetrics() throws SQLException

	{
		return metricBusiness.getMetrics();
		
	}

	
	@RequestMapping(value="/admin/rooms", method=RequestMethod.GET)
	public ResponseEntity<Object> getRooms() {
		
		return new ResponseEntity<>(roomBusiness.getRooms(), HttpStatus.OK);
 
		
	}
	
	@RequestMapping(value="/admin/rooms/{id_room}", method=RequestMethod.GET)
	public ResponseEntity<Object> getUsers(@PathVariable int id_room ) {
		
		return new ResponseEntity<>(userBusiness.getUsers(id_room), HttpStatus.OK);
 
		
	}
	
	@RequestMapping(value="/admin/room/{id_room}/{id_user}", method=RequestMethod.DELETE )
	public @ResponseBody void deleteUser(
			@PathVariable int id_room ,
			@PathVariable int id_user)
	{
		metricBusiness.delete(id_room,id_user);
	}	
}
