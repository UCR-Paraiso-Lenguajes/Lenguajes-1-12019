package com.proyectoUno.grupo5.controller.rest;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.domain.Room;

@RestController
public class RoomControllerRest {
	
	@Autowired
	RoomBussiness roomBusiness;

	@RequestMapping(value="/getRoomPerUser", method=RequestMethod.GET)
	public ResponseEntity<Object> getRoomForUser(@RequestParam("idUser") int idUser) {
		
		return new ResponseEntity<>(roomBusiness.getRooms(idUser), HttpStatus.OK);
 
		
	}
	
	
	@RequestMapping(value="/getRooms", method=RequestMethod.GET)
	public ResponseEntity<Object> getRooms() {
		
		return new ResponseEntity<>(roomBusiness.getRooms(), HttpStatus.OK);
 
		
	}
	
	   @RequestMapping(value="/createRoom/{roomName}/{idUser}", method=RequestMethod.POST)
	    public void ingreso(@PathVariable String roomName,@PathVariable int idUser) {
		   System.out.println(roomName
		   );
		   System.out.println(idUser);
	    	Room room = new Room();
	    	room.setRoomName(roomName);
	    	room.setVersion(0);
	      
	    	
	    	try {
	    		roomBusiness.insertRoom(room);
	    	}
	    	catch (SQLException e) {
				e.printStackTrace();
			}
	    	roomBusiness.assignRoom(idUser);
	    	//return "createRoomSucessfull";
	    }
	
}
