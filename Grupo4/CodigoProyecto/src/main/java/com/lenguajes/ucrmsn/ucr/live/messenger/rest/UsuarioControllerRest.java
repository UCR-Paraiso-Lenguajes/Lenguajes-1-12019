package com.lenguajes.ucrmsn.ucr.live.messenger.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenguajes.ucrmsn.ucr.live.messenger.business.UsuarioBusiness;

@RestController
public class UsuarioControllerRest {
	@Autowired
	private UsuarioBusiness usuarioBusiness;
	

}
