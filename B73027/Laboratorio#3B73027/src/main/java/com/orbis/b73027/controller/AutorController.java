package com.orbis.b73027.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orbis.b73027.data.AutorData;



@Controller
public class AutorController {
	

	@Autowired
	private AutorData autorNegocios;
	
	
	@RequestMapping(value="/verAutores", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "verAutores";
	}
	
	@RequestMapping(value="/verAutores", method=RequestMethod.POST )
	public String mostrar_libros(Model model, @RequestParam("apellidos_autor")String apellidos_autor){
		String apellidos_autorTemp = apellidos_autor;
		model.addAttribute("autor", autorNegocios.searchPorAutorApellido(apellidos_autorTemp));
		return "verAutores";
	}
	
	
	private List<Integer> getListInt(String[] listFromWeb){
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < listFromWeb.length; i++) {
			lista.add(Integer.parseInt(listFromWeb[i]));
		}
		return lista;
	
	}
	
	
	@RequestMapping(value="/editarAutor", method=RequestMethod.GET )
    public String editar(Model model,@RequestParam("idAutor") int idAutor) {
        model.addAttribute("autor",autorNegocios.buscarAutorId(idAutor).next());
        return "editarAutor";
    }
    @RequestMapping(value="/borrarAutor", method=RequestMethod.GET )
    public String borrar(Model model,@RequestParam("idAutor") int idAutor) {
        model.addAttribute("autor",autorNegocios.buscarAutorId(idAutor).next());
        return "borrarAutor";
    }
	
}