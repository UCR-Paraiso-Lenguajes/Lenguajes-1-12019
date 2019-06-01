package com.lenguajes.ucrmsn.ucr.live.messenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenguajes.ucrmsn.ucr.live.messenger.business.GrupoBusiness;


@Controller
public class AdministracionController {
	
	@Autowired
	private GrupoBusiness grupoBusiness; 
	 
	 @RequestMapping(value="/administracionSalas", method=RequestMethod.GET )
	 public String listarSalas(Model model) {
		 
		  model.addAttribute(grupoBusiness.listarGrupos());
		  return "administracionSalas";
	 }
	 
	 @RequestMapping(value="/administracionUsuarios", method=RequestMethod.GET )
	 public String listarUsuarios(Model model) {
		 
		  model.addAttribute(grupoBusiness.usuariosPorGrupo(""));
		  return "administracionUsuarios";
	 }
}
