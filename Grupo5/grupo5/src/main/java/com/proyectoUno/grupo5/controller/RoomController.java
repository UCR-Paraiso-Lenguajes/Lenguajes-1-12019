package com.proyectoUno.grupo5.controller;

import com.proyectoUno.grupo5.business.RoomBussiness;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.sql.SQLOutput;

@Controller
public class RoomController {
    @Autowired
    private RoomBussiness roomBusiness;

   
    @RequestMapping(value = "/createRoom", method = RequestMethod.GET)
    public String insertRoom(Model model,@ModelAttribute(name="room") Room room){
    	
        return "createRoom";
    }
    
    @RequestMapping(value="/createRoom", method=RequestMethod.POST)
    public String ingreso(@ModelAttribute(name="room")  Room room, Model model) {
    	
    	
    	room.setRoomName(room.getRoomName());
    	room.setVersion(0);
      	System.out.print("Grupo creado");
    	
    	try {
    		roomBusiness.insertRoom(room);
    	}
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "createRoomSucessfull";
    }
    }
    
    
    

