package com.lenguajes.ucrmsn.ucr.live.messenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lenguajes.ucrmsn.ucr.live.messenger.business.GrupoBusiness;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.HashEnviados;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Metricas;


@Controller
public class AdministracionController {
	
	@Autowired
	private GrupoBusiness grupoBusiness; 
	private Metricas metricas  = Metricas.getInstancia();	
	 
	 @RequestMapping(value="/administracionSalas", method=RequestMethod.GET )
	 public String listarSalas(Model model) {
		 
		  model.addAttribute("grupos",grupoBusiness.listarGrupos());
		  model.addAttribute("metricas",metricas);
		  return "administracionSalas";
	 }
	 
	 @RequestMapping(value="/administracionUsuarios", method=RequestMethod.GET )
	 public String listarUsuarios(Model model ,@RequestParam("idGrupo") String idGrupo) {
		 
		  model.addAttribute("usuarios",grupoBusiness.usuariosPorGrupo(idGrupo));
		  model.addAttribute("idGrupo",idGrupo);
		  model.addAttribute("metricas",metricas);
		  
		  return "administracionUsuarios";
	 }
	 
	
}
