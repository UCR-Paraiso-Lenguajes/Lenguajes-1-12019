package com.proyectoUno.grupo5.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MessageBussiness;
import com.proyectoUno.grupo5.domain.Admin;
import com.proyectoUno.grupo5.domain.Message;


@RestController
public class MessageControllerRest {

	
		@Autowired
		private MessageBussiness messageBusiness;
		
		 @RequestMapping(value = "/msn/room/{id}/messages", method = RequestMethod.GET)
		 public ResponseEntity<Object> getMessagesForRoom() {

			 	
			 
			 
			 
			 return null;
		 }
	
		
}
