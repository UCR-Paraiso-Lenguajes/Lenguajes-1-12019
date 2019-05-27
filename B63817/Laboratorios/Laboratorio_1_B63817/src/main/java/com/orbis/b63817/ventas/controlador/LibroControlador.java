package com.orbis.b63817.ventas.controlador;



import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orbis.b63817.ventas.dominio.Libro;
import com.orbis.b63817.ventas.logica.LibroLogica;


@Controller
public class LibroControlador {
	@Autowired
private LibroLogica libroLogica;
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET )
	public String listarLibroes(Model model, @RequestParam("id_Editorial") int id_Editorial) {
	Iterator<Libro> listaLibros = libroLogica.mostrarLibros(id_Editorial);
	
	if(!libroLogica.mostrarLibros(id_Editorial).hasNext()) {
		
	    String validacion = "La editorial seleccionada no tiene libros asociados";
		model.addAttribute("vacio",validacion);
	
	}else{
		
		model.addAttribute("listaLibros", listaLibros);
	}
	
		
		return "mostrar_libros";
	}


}

