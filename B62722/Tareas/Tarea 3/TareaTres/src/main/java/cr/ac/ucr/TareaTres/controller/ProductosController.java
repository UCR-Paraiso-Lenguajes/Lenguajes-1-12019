package cr.ac.ucr.TareaTres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.TareaTres.domain.Producto;
import cr.ac.ucr.TareaTres.domain.Productos;
import cr.ac.ucr.TareaTres.exception.Excepcion;

@RestController
public class ProductosController {
	
	private Productos productos = new Productos();

	@RequestMapping("/productos")
	public @ResponseBody Iterable<Producto> listar() throws Excepcion {

		if (!contieneProductos()) {
			throw new Excepcion("No hay productos registrados");
		} else
			return productos.listar();
	}
	
	public boolean contieneProductos() {
		if (productos.listar() != null) {
			return true;
		} else
			return false;
	}
	
}

