package com.orbis.B63199.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.B63199.business.AutorBusiness;
import com.orbis.B63199.domain.Autor;


@RestController
public class AutorControllerRest {

@Autowired
private AutorBusiness autorBusiness;	

@RequestMapping(value="/api/editarAutor/{id}", method=RequestMethod.PUT )
public @ResponseBody void actualizarAutor( 
		@PathVariable int id ,
@RequestBody Autor autor)
{
autorBusiness.update(id , autor);
}

@RequestMapping(value="/api/eliminarAutor/{id}", method=RequestMethod.POST )
public void eliminarAutor(
@PathVariable int id )
{
autorBusiness.delete(id);
}
}