package com.orbis.b73027.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.orbis.b73027.data.AutorData;
import com.orbis.b73027.domain.Autor;



@Controller
public class AutorControllerRest {
	

	@Autowired
	private AutorData autorNegocios;
	
	
	@RequestMapping(value="/api/autor/{id}", method=RequestMethod.PUT)
    public @ResponseBody void actualizarAutor(@PathVariable int id,
                                                    @RequestBody Autor autor){
		autorNegocios.actualizarAutor(id, autor);
        
    }
    @RequestMapping(value="/api/autordelete/{idAutor}", method=RequestMethod.PUT)
    public @ResponseBody void eliminarAutor(@PathVariable int idAutor){
    	autorNegocios.borrarAutor(idAutor);
        
    }
	
}