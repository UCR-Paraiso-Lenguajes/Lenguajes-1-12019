package com.proyectoUno.grupo5.controller.rest;

import java.util.Map;

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
		
		 private Map<Integer, Message> messagesSincro;
		
		@RequestMapping(value = "/msn/insertMessage", method = RequestMethod.POST)
		public ResponseEntity<Object> postInsertMessages(@RequestBody Message message) {
				
			
			messagesSincro = messageBusiness.insertMessageSincro(message);
		    
			return new ResponseEntity<>(messageBusiness.insertMessage(message), HttpStatus.OK);
}
		
		@RequestMapping(value = "/msn/getMessageSincro", method = RequestMethod.GET)
		//public ResponseEntity<Object> getMessages(@RequestBody int IdRoom){
		public Map<Integer, Message> getMessages(){
			
			
			//return new ResponseEntity<>(messageBusiness.getMessagesSincro(1), HttpStatus.OK);
			return messagesSincro;
		}
		
		 
		
}

