package com.proyectoUno.grupo5.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoUno.grupo5.business.MessageBussiness;
import com.proyectoUno.grupo5.domain.Admin;
import com.proyectoUno.grupo5.domain.Message;


@RestController
public class MessageControllerRest {

	
		@Autowired
		private MessageBussiness messageBusiness;
		
		@RequestMapping(value = "/msn/insertMessage", method = RequestMethod.POST)
		public ResponseEntity<Object> getFoosBySimplePathWithPathVariable (@RequestBody Message message) {

			//Message message = new Message(containt, idUser, idRoom);
			return new ResponseEntity<>(messageBusiness.insertMessage(message), HttpStatus.OK);
}
		
		
		
		 
		
}

