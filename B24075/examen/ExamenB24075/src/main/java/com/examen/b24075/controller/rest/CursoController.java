package com.examen.b24075.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.examen.b24075.business.CursoBusiness;

@RestController
public class CursoController {
	
	@Autowired
	private CursoBusiness cursoBusiness;

}
