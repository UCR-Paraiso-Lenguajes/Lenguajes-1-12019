package com.orbis.B77436.controller;

import java.sql.SQLException;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import com.orbis.B77436.business.AutorBusiness;
import com.orbis.B77436.data.EditorialData;
import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;
import com.orbis.B77436.form.AutorForm;
import com.orbis.B77436.form.LibroForm;

@Controller
public class AutorController {
	
	
	@Autowired
	private AutorBusiness autorBusiness;
	
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mantenimientoAutores";
	}
	
	
	@RequestMapping(value="/errorBusqueda", method=RequestMethod.GET )
	public String mensajedelete(Model model) {
		return "errorBusqueda";
	}
	
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.POST )
	public String buscarAutores(Model model, @RequestParam("apellidos_autor") String apellidos_autor) throws SQLException {
		if(!apellidos_autor.equalsIgnoreCase("")) {
			Iterator<Autor> listaAutores = autorBusiness.findApellidosAutor(apellidos_autor);
			if(!listaAutores.hasNext()) {
				return mensajedelete(model);
			}
			model.addAttribute("autor", listaAutores);
		}
		return "mantenimientoAutores";
		
	}
	
	
	@RequestMapping(value="/editarAutor", method=RequestMethod.GET )
	public String mostrar_editar(Model model, @RequestParam("id_autor") int id_autor) throws SQLException {
		if(id_autor==0) throw new RuntimeException("el id autor viene vacío");
		Iterator<Autor> listAutor = autorBusiness.findAutorId(id_autor);
		model.addAttribute("autor", listAutor.next());
		return "editarAutor";
	}
	
	
	@RequestMapping(value="/borrarAutor", method=RequestMethod.GET )
	public String mostrar_borrar(Model model, @RequestParam("id_autor") int id_autor) throws SQLException {
		if(id_autor==0) throw new RuntimeException("el id autor viene vacío");
		model.addAttribute("autor", autorBusiness.findAutorId(id_autor).next());
		return "borrarAutor";
	}
}
