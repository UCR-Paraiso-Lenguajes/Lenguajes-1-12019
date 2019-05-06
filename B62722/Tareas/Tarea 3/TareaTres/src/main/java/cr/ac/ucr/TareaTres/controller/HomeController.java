package cr.ac.ucr.TareaTres.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.TareaTres.domain.Producto;
import cr.ac.ucr.TareaTres.domain.Productos;

@Controller
public class HomeController {

	private Productos productos = new Productos();
	
	@RequestMapping("/")
	public String mensaje(ModelMap model) {
		model.addAttribute("productos", productos.listar());
		/*
		 * No devolver null, de lo contrario Se podrían generar 
		 * diferentes excepciones como NullPointerExcepcion.
		 */
		return "productos";
	}
	
	@RequestMapping(value="/insertarproducto", method = RequestMethod.POST)
	public void insertarProductoAction(HttpServletResponse response, @RequestParam int id, @RequestParam String nombre,
			@RequestParam String categoria, @RequestParam int peso) throws IOException {
		
		Producto producto = new Producto(id, nombre, categoria, peso);
		/*
		 * La ley de Demeter: Un objeto no debe mostrar su estructura interna a través
		 * de métodos de acceso. Un método f de una clase C solo debe invocar los
		 * métodos de: 
		 * C.
		 * Un objeto creado por f. 
		 * Un objeto pasado como argumento a f.
		 * Un objeto en una variable de instancia de C.
		 */
		productos.Agregar(producto);
		response.sendRedirect("/");
	}
}
