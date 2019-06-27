package com.orbis.B74560.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orbis.B74560.business.EditorialBusiness;
import com.orbis.B74560.exception.ExceptionsOrbis;

@Controller
public class EditorialController {

	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value = "/ver_Editoriales", method = RequestMethod.GET)
	public String iniciar(Model model) {
		return "ver_Editoriales";
	}

	@RequestMapping(value = "/ver_Editoriales", method = RequestMethod.POST)
	public String ver_editoriales(Model model, @RequestParam("id_editorial") String id_editorial) {

		if (!ExceptionsOrbis.verificarStringNumero(id_editorial)) {

			throw new ExceptionsOrbis("Solo puede ingresar numeros");

		} else {

			int id_editorialNumero = Integer.parseInt(id_editorial);

			if (id_editorialNumero <= 0) {
				throw new ExceptionsOrbis("Solo puede ingresar numeros mayores de 0");
			} else {
				model.addAttribute("editorial", editorialBusiness.buscarEditorial(id_editorialNumero));
				return "ver_Editoriales";
			} // fin del if mayor de 0

		} // fin del if sea un numero

	}// fin de ver_editoriales
	
}// fin del EditorialController
