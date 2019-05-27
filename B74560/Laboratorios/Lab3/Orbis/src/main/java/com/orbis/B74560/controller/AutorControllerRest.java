package com.orbis.B74560.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.B74560.business.AutorBusiness;
import com.orbis.B74560.domain.Autor;



@Controller
public class AutorControllerRest {
	

	@Autowired
	private AutorBusiness autorBusiness;
	
	
	@RequestMapping(value="/api/autor/{id}", method=RequestMethod.PUT)
    public @ResponseBody void actualizarAutor(@PathVariable int id,
                                                    @RequestBody Autor autor){
		autorBusiness.actualizarAutor(id, autor);
        
    }
    @RequestMapping(value="/api/autordelete/{id}", method=RequestMethod.PUT)
    public @ResponseBody void eliminarAutor(@PathVariable int id){
    	autorBusiness.borrarAutor(id);
        
    }
	
}
