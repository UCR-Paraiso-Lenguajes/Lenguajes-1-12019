package com.lenguajes.ucrmsn.ucr.live.messenger.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lenguajes.ucrmsn.ucr.live.messenger.business.UsuarioBusiness;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.HashEnviados;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Rol;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.RolUsuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.UsuarioAdmin;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.UsuarioOwner;

@Controller
public class UsuarioController {
	
	  @Autowired 
	  private UsuarioBusiness usuarioBusiness;
	  private HashEnviados enlacesEnviados=HashEnviados.getInstancia();	

	  
	  @RequestMapping(value = "/msn", method = RequestMethod.GET) public String
	  enviarCorreo() { return "msn"; }
	  
	  @RequestMapping(value = "/msn", method = RequestMethod.POST) public String
	  sendMail(@RequestParam("CorreoElectronico") String mail) {
	  
	  usuarioBusiness.invitar(mail);
	  
	  return "msn"; 
	  }
	  
	  @RequestMapping(value = "/interfazchat", method = RequestMethod.GET) 
	  public String chatsUsuario(Model model,@RequestParam("hash") String hash) { 
		  
		  
		  if(enlacesEnviados.contiene(hash)) {
			  Usuario usuario=new Usuario(hash);
			  ArrayList<Rol> listaRoles=usuario.getListaRoles();

			  listaRoles.add(new RolUsuario(0,"usuario"));
			  listaRoles.add(new RolUsuario(0,"usuario"));
			  usuario.setListaRoles(listaRoles);
			  
			  usuarioBusiness.save(usuario);
			 			  
			  Grupo grupo1=new Grupo("los amigos", 0, 0, new UsuarioAdmin("dssdjds"), new UsuarioOwner("dsjsds"));
			  Grupo grupo2= new Grupo("bebasos", 0, 0, new UsuarioAdmin("dssdjds"), new UsuarioOwner("dsjsds"));
			  Mensaje mensaje=new Mensaje(usuario, "hola juan",1, grupo1);
			
			  grupo1.mandarMensaje(mensaje);
			 		  
			  
			 
			  usuario=usuarioBusiness.asignarNombreYAvatar(usuario);
			  usuario.nuevoGrupo(grupo1);
			  usuario.nuevoGrupo(grupo2);
			  
			  
			  model.addAttribute("usuario", usuario );
			  model.addAttribute("grupos", usuario.getListaGrupos() );
			  model.addAttribute("mensajes", usuario.getListaGrupos().get(0).getListaMensajes() );

			  return "interfazchat";   
		
		  }else if(usuarioBusiness.existeHash(hash)){
			  Usuario usuario=usuarioBusiness.getUsuarioHash(hash);
			  Grupo grupo1=new Grupo("los amigos", 0, 0, new UsuarioAdmin("dssdjds"), new UsuarioOwner("dsjsds"));
			  Grupo grupo2= new Grupo("bebasos", 0, 0, new UsuarioAdmin("dssdjds"), new UsuarioOwner("dsjsds"));
			  Mensaje mensaje=new Mensaje(usuario, "hola juan",1, grupo1);
			
			  grupo1.mandarMensaje(mensaje);
			 		  
			  
			  ArrayList<Rol> listaRoles=usuario.getListaRoles();
			  listaRoles.add(new RolUsuario(0,"usuario"));
			  usuario.setListaRoles(listaRoles);
			  usuario=usuarioBusiness.asignarNombreYAvatar(usuario);
			  usuario.nuevoGrupo(grupo1);
			  usuario.nuevoGrupo(grupo2);
			  
			  
			  model.addAttribute("usuario", usuario );
			  model.addAttribute("grupos", usuario.getListaGrupos() );
			  model.addAttribute("mensajes", usuario.getListaGrupos().get(0).getListaMensajes() );
			  
			/*
			 * model.addAttribute("usuario", usuario ); model.addAttribute("grupos",
			 * usuario.getListaGrupos() );
			 */
			/*
			 * if(usuario.getListaGrupos() !=null) { model.addAttribute("mensajes",
			 * usuario.getListaGrupos().get(0).getListaMensajes() );
			 * 
			 * }else { model.addAttribute("mensajes",usuario.getListaGrupos() );
			 * 
			 * }
			 */

			  return "interfazchat";   
		  }else { return "expiroenlace"; }
		 
		  
		  
	  }
	 

}

