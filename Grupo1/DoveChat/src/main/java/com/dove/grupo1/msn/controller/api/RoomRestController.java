package com.dove.grupo1.msn.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoomRestController {
	
	/**
	 * Api para recibir el correo en nuevo login
	 * @param String email
	 */
	@RequestMapping(value="/api/user/{email}", method=RequestMethod.PUT)
	public @ResponseBody void userLogin(@PathVariable String email){
		email.charAt(0);
	}
}
