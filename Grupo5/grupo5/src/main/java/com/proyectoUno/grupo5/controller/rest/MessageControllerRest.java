package com.proyectoUno.grupo5.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyectoUno.grupo5.business.MessageBussiness;
import com.proyectoUno.grupo5.domain.Admin;
import com.proyectoUno.grupo5.domain.Message;

@RestController
public class MessageControllerRest {

	@Autowired
	private MessageBussiness messageBusiness;

	private Map<Integer, Message> messagesSincro;



		@RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
	public ResponseEntity<Object> postInsertMessages(@RequestBody Message message) {

		return new ResponseEntity<>(messageBusiness.insertMessage(message), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getMessages", method = RequestMethod.GET)
	public ResponseEntity<Object> getMessages(@RequestParam("idRoom") int idRoom){

		return new ResponseEntity<>(messageBusiness.getMessagesSincro(messageBusiness.getMessagesByIdRoom(idRoom)),  HttpStatus.OK);
	}

}
