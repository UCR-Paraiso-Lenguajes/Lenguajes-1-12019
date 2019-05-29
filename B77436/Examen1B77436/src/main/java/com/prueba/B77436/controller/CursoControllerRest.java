package com.prueba.B77436.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.B77436.domain.Curso;


@RestController
public class CursoControllerRest {
	
	
	
	@RequestMapping(value="/ucr/api/carreras/{carreras}", method=RequestMethod.PUT )
	public @ResponseBody void update(@PathVariable int id, @RequestBody Curso autor) {
		if(id==0 ) throw new RuntimeException("El id viene vacío");
		
	}
	
	
	
	

}
