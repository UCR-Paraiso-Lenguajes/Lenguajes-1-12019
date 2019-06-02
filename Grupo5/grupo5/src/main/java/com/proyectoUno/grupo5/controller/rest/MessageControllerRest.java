package com.proyectoUno.grupo5.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MessageBussiness;


@RestController
public class MessageControllerRest {

	
		@Autowired
		private MessageBussiness messageBusiness;
		
		
	
		
}
