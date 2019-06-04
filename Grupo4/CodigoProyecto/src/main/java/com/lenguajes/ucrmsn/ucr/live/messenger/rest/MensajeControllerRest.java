package com.lenguajes.ucrmsn.ucr.live.messenger.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenguajes.ucrmsn.ucr.live.messenger.business.GrupoBusiness;
import com.lenguajes.ucrmsn.ucr.live.messenger.business.UsuarioBusiness;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;


@RestController
public class MensajeControllerRest {
	@Autowired
	private GrupoBusiness grupoBusiness;	
	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@RequestMapping(value="/api/mandarMensaje", method=RequestMethod.POST )
	public @ResponseBody void mandarMensaje(
			@PathVariable String contenido,@PathVariable String hashUsuario)
	{
		Mensaje mensaje=new Mensaje();
		mensaje.setContenido(contenido);
		mensaje.setUsuario(usuarioBusiness.getUsuarioHash(hashUsuario));
		
		grupoBusiness.guardarMensajes(mensaje.getGrupo(), mensaje.getUsuario(), mensaje);
	}
}

