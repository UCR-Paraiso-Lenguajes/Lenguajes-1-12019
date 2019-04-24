package cr.ac.ucr.TareaTres.domain;

import java.util.ArrayList;

public class Productos {

	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Productos() {
		/*
		 * No pasar null
		 * Siempre que se pueda se debe evitar pasar un null en mÃ©todos.
		 */
		Agregar(new Producto(01, "Arroz", "Abarrotes", 1500));
	}
	
	public void Agregar(Producto producto) {
		/*
		 * Usar excepciones en lugar de códigos devueltos. Es mejor generar una
		 * excepción al detectar un error.
		 */
		if (productos.contains(producto)) throw new RuntimeException("El producto ya existe.");
		productos.add(producto);
	}
	
	public Iterable<Producto> listar(){
		return productos;
		
	}
	
}

