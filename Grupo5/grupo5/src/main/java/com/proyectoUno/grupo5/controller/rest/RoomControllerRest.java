package com.proyectoUno.grupo5.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.RoomBussiness;

@RestController
public class RoomControllerRest {
	
	@Autowired
	RoomBussiness roomBusiness;

	@RequestMapping(value="/getRoomPerUser", method=RequestMethod.GET)
	public ResponseEntity<Object> getDataAutor(@RequestParam("idUser") int idUser) {
		
		return new ResponseEntity<>(roomBusiness.getRooms(idUser), HttpStatus.OK);
 
		
	}
	
	
	
}
