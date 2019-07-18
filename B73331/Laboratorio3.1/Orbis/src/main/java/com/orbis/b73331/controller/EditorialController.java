package com.orbis.b73331.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b73331.business.EditorialBusiness;
import com.orbis.b73331.domain.OrbisExcepcion;

@Controller
public class EditorialController {
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/findEditorial", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "findEditorial";
	}
	@RequestMapping(value="/findEditorial", method=RequestMethod.POST )
	public String buscarPorId(Model model, @RequestParam("id") String id, @RequestParam("desde") String desde, @RequestParam("hasta") String hasta) {
		
			if(desde.equals("")&&hasta.equals("")&&!id.equals("")) {
			
				model.addAttribute("editoriales", editorialBusiness.buscarPorId(Integer.parseInt(id)));
			
			
			}else if(id.equals("")&&!desde.equals("")&&!hasta.equals("")){
				if(Integer.parseInt(desde)<0||Integer.parseInt(hasta)<0) {
					throw new OrbisExcepcion("No debe meter numeros negativos");
				}
					model.addAttribute("editoriales", editorialBusiness.buscarPorRango(Integer.parseInt(desde), Integer.parseInt(hasta)));
			}else if(id.equals("")&&!desde.equals("")&&hasta.equals("")) {
				throw new OrbisExcepcion("Los campos no de rango no deben quedar vacios (hasta)");
			}else if(id.equals("")&&desde.equals("")&&!hasta.equals("")) {
				throw new OrbisExcepcion("Los campos no de rango no deben quedar vacios (desde)");
			}else if(id.equals("")&&desde.equals("")&&hasta.equals("")) {
				throw new OrbisExcepcion("Todos campos no deben quedar vacios (desde, hasta, id)");
			}else if(!id.equals("")&&!desde.equals("")&&!hasta.equals("")) {
				throw new OrbisExcepcion("Todos campos no deben estar llenos, elija algunoas de los dos metodos de "
						+ "busqueda (desde, hasta, id)");
			}
		
		
		
		
		return "findEditorial";
	}
	
}
