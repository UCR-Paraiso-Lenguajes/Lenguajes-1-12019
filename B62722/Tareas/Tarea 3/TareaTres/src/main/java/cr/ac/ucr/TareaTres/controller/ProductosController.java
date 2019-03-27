package cr.ac.ucr.TareaTres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.TareaTres.domain.Producto;
import cr.ac.ucr.TareaTres.domain.Productos;

@RestController
public class ProductosController {
	
	private Productos productos = new Productos();
	
	@SuppressWarnings("finally")
	@RequestMapping("/productos")
	public @ResponseBody Iterable<Producto> listar() {
		/*
		 * Crear primero la instrucciòn try-catch-finally
		 */
		try {
			productos.listar();
		} catch (Exception e) {
			throw new NullPointerException("No hay productos registrados");
		} finally {
			return productos.listar();
		}
		
	}
	
}

